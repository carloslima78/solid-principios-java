package com.solid.principios.itau.OCP.Solucao;

public class ContaPoupanca extends Conta {

    @Override
    public String Debitar(String conta, String agencia, Double valor){

        final Double SALDO_CONTA_POUPANCA = 20.000;
        final String CONTA_POUPANCA  = "33334444";
        final String AGENCIA = "333";

        Double saldoRestante;
        String mensagem = "";

        if (conta == CONTA_POUPANCA  && agencia == AGENCIA){

            if (valor >= SALDO_CONTA_POUPANCA){

                saldoRestante = SALDO_CONTA_POUPANCA - valor;
                mensagem = "Débito realizado, seu saldo é de " +  saldoRestante;
            }

            else{
                mensagem = "Saldo insuficiente.";
            }
        }

        return mensagem;
    }
}
