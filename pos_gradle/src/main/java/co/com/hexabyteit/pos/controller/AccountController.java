package co.com.hexabyteit.pos.controller;

import co.com.hexabyteit.pos.model.service.ResponseListUser;
import co.com.hexabyteit.pos.service.AccountService;
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
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("account/status")
    public String status(){
        return "AccountController Funciona correctamente";
    }

    @GetMapping("account/users")
    public ResponseEntity<ResponseListUser> getUsers(){
        log.info("Controlador Account/users");
        return new ResponseEntity<>(accountService.getListUsuarios(), HttpStatus.OK);
    }

    @GetMapping("account/user")
    public ResponseEntity<ResponseListUser> getUsers(String account){
        log.info("Controlador Account/user");
        return new ResponseEntity<>(accountService.getListUsuarios(), HttpStatus.OK);
    }
}
