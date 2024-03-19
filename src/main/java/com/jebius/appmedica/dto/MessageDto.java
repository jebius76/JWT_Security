package com.jebius.appmedica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class MessageDto {

    private LocalDateTime date;
    private String msg;

    public MessageDto(String msg) {
        this.date = LocalDateTime.now();
        this.msg = msg;
    }
}
