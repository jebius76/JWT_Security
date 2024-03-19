package com.jebius.appmedica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorMessageDto {

    private LocalDateTime date;
    private String exception;
    private Object msg;

    public ErrorMessageDto(String exception, Object msg) {
        this.date = LocalDateTime.now();
        this.exception = exception;
        this.msg = msg;
    }
}
