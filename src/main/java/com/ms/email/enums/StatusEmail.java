package com.ms.email.enums;

import lombok.Getter;

@Getter
public enum StatusEmail {
    SENT(1),
    ERROR(2);

    private final int value;

    StatusEmail(int value) {
        this.value = value;
    }

}
