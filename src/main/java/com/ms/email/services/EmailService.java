package com.ms.email.services;

import com.ms.email.entities.EmailEntity;
import com.ms.email.enums.StatusEmail;
import com.ms.email.repositories.EmailRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final EmailRepository emailRepository;
    private final JavaMailSender emailSender;
    @Value(value = "${spring.mail.username}")
    private String emailFrom;

    @Transactional
    public void sendEmail(EmailEntity emailEntity) {

        try{
            emailEntity.setSendDateEmail(LocalDateTime.now());
            emailEntity.setEmailFrom(emailFrom);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(emailEntity.getEmailTo());
            message.setSubject(emailEntity.getSubject());
            message.setText(emailEntity.getText());
            emailSender.send(message);

            emailEntity.setStatusEmail(StatusEmail.SENT);
        }catch (MailException e){
            System.out.println("Erro ao enviar e-mail: " + e.getMessage());
            emailEntity.setStatusEmail(StatusEmail.ERROR);
        } finally {
           emailRepository.save(emailEntity);
        }
    }
}
