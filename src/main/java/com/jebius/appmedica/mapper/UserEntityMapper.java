package com.jebius.appmedica.mapper;

import com.jebius.appmedica.dto.LoginUserResponseDto;
import com.jebius.appmedica.entity.UserEntity;
import com.jebius.appmedica.repository.UserEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class UserEntityMapper {

    UserEntityRepository userEntityRepository;
    public LoginUserResponseDto mapLoginUserResponseDto(String email){

        UserEntity userEntity = userEntityRepository.findByEmail(email).get();
        return new LoginUserResponseDto(userEntity.getId(), userEntity.getUserName(), userEntity.getEmail());
    }

}
