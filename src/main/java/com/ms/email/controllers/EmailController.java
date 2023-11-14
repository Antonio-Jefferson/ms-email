package com.ms.email.controllers;

import com.ms.email.dtos.EmailDTO;
import com.ms.email.entities.EmailEntity;
import com.ms.email.services.EmailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @PostMapping("/sending-email")
    public ResponseEntity<EmailEntity> sendingEmail(@RequestBody @Valid EmailDTO emailDto){
        EmailEntity emailEntity = new EmailEntity();
        BeanUtils.copyProperties(emailDto, emailEntity);
        emailService.sendEmail(emailEntity);
        return new ResponseEntity<>(emailEntity, HttpStatus.CREATED);
    }
}
