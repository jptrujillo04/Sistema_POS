package co.com.hexabyteit.pos.controller;

import co.com.hexabyteit.pos.model.service.ResponseListCompany;
import co.com.hexabyteit.pos.model.service.ResponseListRole;
import co.com.hexabyteit.pos.service.CompanyService;
import co.com.hexabyteit.pos.service.RoleService;
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
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("role/status")
    public String status(){
        return "Funciona correctamente RoleController";
    }

    @GetMapping("role/roles")
    public ResponseEntity<ResponseListRole> getRoles(){
        log.info("Controlador RoleController/roles");
        return new ResponseEntity<>(roleService.getListRole(), HttpStatus.OK);
    }
}
