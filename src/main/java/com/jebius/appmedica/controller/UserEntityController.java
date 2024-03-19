package com.jebius.appmedica.controller;

import com.jebius.appmedica.dto.ErrorMessageDto;
import com.jebius.appmedica.dto.LoginUserResponseDto;
import com.jebius.appmedica.entity.UserEntity;
import com.jebius.appmedica.mapper.UserEntityMapper;
import com.jebius.appmedica.service.UserEntityService;
import com.jebius.appmedica.service.UserEntityServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserEntityController {

    UserEntityServiceImpl userEntityService;

    UserEntityMapper userEntityMapper;

    @GetMapping ("/details")
    public ResponseEntity<?> userDetails(){
        String loggedUser = SecurityContextHolder.getContext().getAuthentication().getName();
        if (Objects.equals(loggedUser, "anonymousUser")){
            return new ResponseEntity<>(new ErrorMessageDto("You are in anonymous mode",null), HttpStatus.BAD_REQUEST);
        }
        UserEntity user = userEntityService.findByEmail(loggedUser).get();
        return new ResponseEntity<>(userEntityMapper.mapLoginUserResponseDto(loggedUser), HttpStatus.OK);
    }
}
