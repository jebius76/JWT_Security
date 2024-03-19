package com.jebius.appmedica.service;

import com.jebius.appmedica.dto.RegisterUserDto;
import com.jebius.appmedica.entity.Role;
import com.jebius.appmedica.entity.UserEntity;
import com.jebius.appmedica.exception.UserAlreadyExistException;
import com.jebius.appmedica.repository.RoleRepository;
import com.jebius.appmedica.repository.UserEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserEntityServiceImpl implements UserEntityService{
    @Autowired
    UserEntityRepository userEntityRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public UserEntity registerUser(RegisterUserDto registerUserDto) {

        if (userEntityRepository.findByEmail(registerUserDto.getEmail()).isPresent()){
            throw new UserAlreadyExistException("User already exist");
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(registerUserDto.getUserName());
        userEntity.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));
        userEntity.setRole(roleRepository.findByRole("USER").get());
        userEntity.setEmail(registerUserDto.getEmail());
        try {
            return userEntityRepository.save(userEntity);
        } catch (Exception e) {
            throw new RuntimeException("Error registering user");
        }
    }

    public Optional<UserEntity> findByEmail(String email){
        return userEntityRepository.findByEmail(email);
    }
}
