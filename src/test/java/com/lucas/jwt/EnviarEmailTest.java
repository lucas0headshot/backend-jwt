package com.lucas.jwt;

import com.lucas.jwt.services.EmailService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EnviarEmailTest {
    @Autowired
    private EmailService emailService;


    @Test
    public void enviarEmail() {
        emailService.enviarEmail("lucas0headshot@gmail.com", "raphaelazambuja5@gmail.com", "Para porra", "Vai marcar a gente, Markinhos vai bloquear");
    }
}
