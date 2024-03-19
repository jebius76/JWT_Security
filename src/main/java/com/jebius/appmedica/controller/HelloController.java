package com.jebius.appmedica.controller;


import com.jebius.appmedica.dto.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloController {

    @GetMapping("")
    public String hello(){
        return "Hello, you are authenticated as: " + SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    }
    @GetMapping("/secureAdmin")
    public ResponseEntity<?> secureAdmin(){
        return new ResponseEntity<>(new MessageDto("This is secured to ADMIN"), HttpStatus.OK);
    }

    @GetMapping("/secureUser")
    public ResponseEntity<?> secureUser(){
        return new ResponseEntity<>(new MessageDto("This is secured to USER"), HttpStatus.OK);
    }

}
