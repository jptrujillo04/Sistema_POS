package com.hexabyteit.api.pos.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("v0")
public class Login {

    @GetMapping("/status")
    public String status(){
        return "Hola Mundo";
    }
}
