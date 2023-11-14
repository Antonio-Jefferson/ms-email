package com.ms.email.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailDTO {
    @NotBlank
    private Long emailId;
    @NotBlank
    @Email
    private String ownerRef;
    @NotBlank
    @Email
    private String emailFrom;
    @NotBlank
    private String emailTo;
    @NotBlank
    private String subject;
    @NotBlank
    private String text;
}
