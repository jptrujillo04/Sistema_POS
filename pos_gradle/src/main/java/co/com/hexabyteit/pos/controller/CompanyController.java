package co.com.hexabyteit.pos.controller;

import co.com.hexabyteit.pos.model.service.ResponseListCompany;
import co.com.hexabyteit.pos.service.CompanyService;
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
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("company/status")
    public String status(){
        return "Funciona correctamente CompanyController";
    }

    @GetMapping("company/companies")
    public ResponseEntity<ResponseListCompany> getCompanies(){
        log.info("Controlador company/companies");
        return new ResponseEntity<>(companyService.getListCompanies(), HttpStatus.OK);
    }
}
