package com.jebius.appmedica.service;

import com.jebius.appmedica.dto.RegisterUserDto;
import com.jebius.appmedica.entity.UserEntity;

import java.util.Optional;

public interface UserEntityService {

    UserEntity registerUser(RegisterUserDto registerUserDto);

    Optional<UserEntity> findByEmail(String email);
}
