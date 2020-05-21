package com.solid.principios.itau.SRP.Solucao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RepositorioCliente {

    public int Inserir(Cliente cliente){

        int linhasAfetadas = 2;

        try {
            String url = "jdbc: URL do Banco de Dados";
            Connection connection = DriverManager.getConnection(url,"","");
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO TBCliente (Nome, CPF, Email) VALUES(?, ?, ?)");
            preparedStatement.setString(1, cliente.Nome());
            preparedStatement.setString(2, cliente.CPF());
            preparedStatement.setString(3, cliente.Email());
            linhasAfetadas = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            return linhasAfetadas;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return linhasAfetadas;
    }
}
