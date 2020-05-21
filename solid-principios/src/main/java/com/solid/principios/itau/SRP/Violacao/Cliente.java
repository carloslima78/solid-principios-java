package com.solid.principios.itau.SRP.Violacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import java.sql.*;
import java.sql.PreparedStatement;

public class Cliente {

    private Integer _idCliente;
    private String _nome;
    private String _cpf;
    private String _email;

    public Integer IdCliente() {
        return this._idCliente;
    }

    public void IdCliente(Integer idCliente) {
        this._idCliente = idCliente;
    }

    public String Nome(){
        return this._nome;
    }

    public void Nome(String nome){
        this._nome = nome;
    }

    public String CPF(){
        return this._cpf;
    }

    public void CPF(String cpf){
        this._cpf = cpf;
    }

    public String Email(){
        return this._email;
    }

    public void Email(String email){
        this._email = email;
    }

    public void Inserir(Cliente cliente){
        try {
            String url = "jdbc: URL do Banco de Dados";
            Connection connection = DriverManager.getConnection(url,"","");
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO TBCliente (Nome, CPF, Email) VALUES(?, ?, ?)");
            preparedStatement.setString(1, cliente.Nome());
            preparedStatement.setString(2, cliente.CPF());
            preparedStatement.setString(3, cliente.Email());

            if(preparedStatement.executeUpdate() > 0){
                this.EnviarEmail("Saudações", "Saudações ao novo cliente", "ben@contoso", cliente.Email());
            }

            preparedStatement.close();
            connection.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private JavaMailSender mailSender;

    public String EnviarEmail(String assunto, String corpo, String de, String para) {

        SimpleMailMessage mailMessagemessage = new SimpleMailMessage();
        mailMessagemessage.setSubject(assunto);
        mailMessagemessage.setText(corpo);
        mailMessagemessage.setTo(para);
        mailMessagemessage.setFrom(de);

        try {
            mailSender.send(mailMessagemessage);
            return "Email enviado com sucesso!";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar email.";
        }
    }
}
