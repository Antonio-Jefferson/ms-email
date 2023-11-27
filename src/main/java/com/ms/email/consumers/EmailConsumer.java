package com.ms.email.consumers;

import com.ms.email.dtos.EmailDTO;
import com.ms.email.entities.EmailEntity;
import com.ms.email.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailConsumer {
    private final EmailService emailService;

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailDTO emailDTO){
        EmailEntity emailEntity = EmailEntity.toEntity(emailDTO);
        emailService.sendEmail(emailEntity);
    }
}
