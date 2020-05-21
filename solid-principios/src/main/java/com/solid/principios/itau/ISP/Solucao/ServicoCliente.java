package com.solid.principios.itau.ISP.Solucao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServicoCliente implements IEmail, IDocumento {
    @Override
    public Boolean ValidarDocumento(String documento) {
        Boolean resposta = true;

        if (documento.length() > 11 || documento.length() < 11)
            resposta = false;

        return resposta;
    }

    @Override
    public Boolean ValidarEmail(String email) {

        Pattern regexValidar  =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

        Matcher matcher = regexValidar.matcher(email);

        return matcher.find();
    }
}
