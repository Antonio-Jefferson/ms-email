package com.ms.email.services;

import com.ms.email.entities.EmailEntity;
import com.ms.email.enums.StatusEmail;
import com.ms.email.repositories.EmailRepository;
import lombok.RequiredArgsConstructor;
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

    public EmailEntity sendEmail(EmailEntity emailEntity) {
        emailEntity.setSendDateEmail(LocalDateTime.now());
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailEntity.getEmailFrom());
            message.setTo(emailEntity.getEmailTo());
            message.setSubject(emailEntity.getSubject());
            message.setText(emailEntity.getText());
            emailSender.send(message);

            emailEntity.setStatusEmail(StatusEmail.SENT);
        }catch (MailException e){
            emailEntity.setStatusEmail(StatusEmail.ERROR);
        } finally {
            return emailRepository.save(emailEntity);
        }
    }
}
