package com.solid.principios.itau.OCP.Solucao;

public class ContaCorrente extends Conta {

    @Override
    public String Debitar(String conta, String agencia, Double valor){

        final Double SALDO_CONTA_CORRENTE = 10.000;
        final Double SALDO_LIMITE = 2.000 + SALDO_CONTA_CORRENTE;
        final String CONTA_CORRENTE = "11112222";
        final String AGENCIA = "333";

        Double saldoRestante;
        String mensagem = "";

        if (conta == CONTA_CORRENTE && agencia == AGENCIA){

            if (valor >= SALDO_CONTA_CORRENTE){
                saldoRestante = SALDO_CONTA_CORRENTE - valor;
                mensagem = "Débito realizado, seu saldo é de " + saldoRestante;
            }

            else if (valor >= SALDO_LIMITE){
                saldoRestante = SALDO_LIMITE - valor;
                mensagem = "Débito realizado, porém, utilizando o limite, seu saldo é de " +  saldoRestante ;
            }

            else{
                mensagem = "Saldo insuficiente.";
            }
        }

        return mensagem;
    }
}
