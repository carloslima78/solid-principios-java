package com.solid.principios.itau.DIP.Violacao;

public class ServicoCliente {

    public int Inserir(Cliente cliente){

        RepositorioCliente repositorio = new RepositorioCliente();
        return repositorio.Inserir(cliente);
    }
}
