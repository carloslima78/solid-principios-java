package com.solid.principios.itau.ISP.Violacao;

public interface IValidacao {

    Boolean ValidarEmail(String email);

    Boolean ValidarDocumento(String documento);

    Boolean ValidarCodigoBarras(String codigoBarras);
}
