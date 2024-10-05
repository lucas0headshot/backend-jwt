package com.lucas.jwt.services;

import com.lucas.jwt.models.domain.FilaEmail;
import com.lucas.jwt.repositories.FilaEmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;
    private final FilaEmailRepository filaEmailRepository;


    public void enviarEmail(String email_de, String email_para, String titulo, String mensagem) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom(email_de);
        email.setTo(email_para);
        email.setSubject(titulo);
        email.setText(mensagem);

        javaMailSender.send(email);
    }


    public void addEmail(String email) {
        FilaEmail fila = new FilaEmail();
        fila.setEmail(email);
        fila.setEnviado(false);
        filaEmailRepository.save(fila);
    }


    @Scheduled(fixedRate = 30000)
    public void processFilaEmails() {
        List<FilaEmail> emails_para_enviar = filaEmailRepository.findByEnviado(false);

        for (FilaEmail filaEmail : emails_para_enviar)
        {
            try {
                enviarEmail("lucas0headshot@gmail.com", filaEmail.getEmail(), "Seja bem-vindo!", "Teste envio e-mail após registrar-se");
                filaEmail.setEnviado(true);
                filaEmailRepository.save(filaEmail);
            } catch (Exception e) {
                System.out.println("Erro ao tentar enviar e-mails: " + e.getMessage());
            }
        }
    }
}
