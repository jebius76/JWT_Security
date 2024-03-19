package com.jebius.appmedica.dto;

import com.jebius.appmedica.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserResponseDto {

    private Long id;
    private String userName;
    private String email;
}
