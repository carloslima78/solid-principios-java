package com.solid.principios.itau.OCP.Solucao;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class ContaInvestimento extends Conta {

    @Override
    public String Debitar(String conta, String agencia, Double valor) {

        final Double SALDO_CONTA_INVESTIMENTO = 20.000;
        final String CONTA_INVESTIMENTO = "33334444";
        final String AGENCIA = "333";
        final int MES_ANIVERSARIO = 5;
        final int MESES_CARENCIA = 6;

        Double saldoRestante;
        String mensagem = "";

        if (conta == CONTA_INVESTIMENTO && agencia == AGENCIA){

            Date date = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            if ((localDate.getMonthValue() - MES_ANIVERSARIO) < MESES_CARENCIA){

                mensagem = "Ainda no período de carância";
            }

            else
            {
                if (valor >= SALDO_CONTA_INVESTIMENTO)
                {
                    saldoRestante = SALDO_CONTA_INVESTIMENTO - valor;
                    mensagem = "Débito realizado, seu saldo é de " +  saldoRestante;
                }
                else
                {
                    mensagem = "Saldo insuficiente.";
                }
            }
        }

        return mensagem;
    }
}
