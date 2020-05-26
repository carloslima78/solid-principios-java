package com.solid.principios.itau.SRP.Solucao;

public class ServicoCliente {

    public void InserirCliente(Cliente cliente){

        RepositorioCliente repositorio = new RepositorioCliente();

        if (repositorio.Inserir(cliente) == 1){
            ServicoEmail.EnviarEmail("Saudações", "Saudações ao novo cliente", "ben@contoso", cliente.Email());
        }
    }
}
