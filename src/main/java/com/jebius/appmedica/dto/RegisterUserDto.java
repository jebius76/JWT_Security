package com.jebius.appmedica.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dto that represents data to register a new user.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDto {
    @NotBlank(message = "Username must not be null or blank")
    private String userName;
    @NotBlank(message = "Password must not be null or blank")
    private String password;
    @Email(message = "Email invalid")
    private String email;
}


