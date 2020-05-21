package com.solid.principios.itau.LSP.Solucao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Seguro extends Produto {

    @Override
    public String Pagar(Double valor){
        final Double SALDO_CONTA_CORRENTE = 10.000;

        Double saldoRestante;
        String mensagem = "";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataVencimento = simpleDateFormat.parse("10/05/2020", null);

        Calendar dataCorrente = Calendar.getInstance();

        if (dataCorrente.getTime().after((dataVencimento))){
            mensagem = "Seguro vencido.";
        }

        else{

            if (valor >= SALDO_CONTA_CORRENTE){
                saldoRestante = SALDO_CONTA_CORRENTE - valor;
                mensagem = "Seguro pago com sucesso, seu saldo é de " + saldoRestante;
            }
            else{
                mensagem = "Saldo insuficiente.";
            }
        }
        return mensagem;
    }
}
