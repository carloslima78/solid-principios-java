package com.solid.principios.itau.SRP.Solucao;

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

    public void InserirCliente(Cliente cliente){

        RepositorioCliente repositorio = new RepositorioCliente();

        if (repositorio.Inserir(cliente) == 1){
            ServicoEmail.EnviarEmail("Saudações", "Saudações ao novo cliente", "ben@contoso", cliente.Email());
        }
    }
}
