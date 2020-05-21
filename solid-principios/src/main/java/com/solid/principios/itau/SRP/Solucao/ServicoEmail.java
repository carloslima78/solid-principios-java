package com.solid.principios.itau.SRP.Solucao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class ServicoEmail {

    @Autowired
    private static JavaMailSender mailSender;

    public static String EnviarEmail(String assunto, String corpo, String de, String para) {

        SimpleMailMessage mailMessagemessage = new SimpleMailMessage();
        mailMessagemessage.setSubject(assunto);
        mailMessagemessage.setText(corpo);
        mailMessagemessage.setTo(para);
        mailMessagemessage.setFrom(de);

        try {
            mailSender.send(mailMessagemessage);
            return "Email enviado com sucesso!";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar email.";
        }
    }
}
