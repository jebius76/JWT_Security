package com.jebius.appmedica.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dto that represents data to user login.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserDto {
    @Email(message = "Email invalid")
    private String email;
    @NotBlank(message = "Password must not be null or blank")
    private String password;
}
