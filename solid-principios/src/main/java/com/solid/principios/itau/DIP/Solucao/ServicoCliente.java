package com.solid.principios.itau.DIP.Solucao;

import org.springframework.beans.factory.annotation.Autowired;

public class ServicoCliente {

    private IRepositorioCliente _repositorio;

    @Autowired
    public ServicoCliente(IRepositorioCliente repositorio){

        _repositorio = repositorio;
    }

    public int Inserir(Cliente cliente)
    {
        return _repositorio.Inserir(cliente);
    }
}
