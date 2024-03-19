package com.jebius.appmedica.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;


/**
 * User entity. Only stores username, password and role and is used to
 * login.
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String email;
    private String password;
    @ManyToOne
    private Role role;
}
