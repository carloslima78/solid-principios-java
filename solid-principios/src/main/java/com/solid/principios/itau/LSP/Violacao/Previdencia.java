package com.solid.principios.itau.LSP.Violacao;

public class Previdencia extends Produto {

    @Override
    public String Pagar(Double valor){

        final Double SALDO_CONTA_CORRENTE = 10.000;

        Double saldoRestante;
        String mensagem = "";

        if (valor >= SALDO_CONTA_CORRENTE)
        {
            saldoRestante = SALDO_CONTA_CORRENTE - valor;
            mensagem = "Título de previdência pago com sucesso, seu saldo é de " + saldoRestante;
        }
        else
        {
            mensagem = "Saldo insuficiente.";
        }

        return mensagem;
    }

    public String Render(Double taxa)
    {
        final Double SALDO_CONTA_PREVIDENCIA = 50.000;

        Double rendimento = ((taxa * SALDO_CONTA_PREVIDENCIA) / 100) / 100;
        Double saldoAtualizado = rendimento + SALDO_CONTA_PREVIDENCIA;

        return "Seu rendimento foi de { rendimento }, seu saldo é de " + saldoAtualizado;
    }
}
