package com.hexabyteit.api.pos.controller;

import com.hexabyteit.api.pos.model.modelservice.ResponseListCompany;
import com.hexabyteit.api.pos.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("v0")
@Slf4j
public class Login {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/status")
    public String status(){
        return "Funciona correctamente";
    }

    @GetMapping("/companies")
    public ResponseEntity<ResponseListCompany> getCompanies(){
        log.info("Controlador companies");
        return new ResponseEntity<>(companyService.getListCompanies(), HttpStatus.OK);
    }
}
