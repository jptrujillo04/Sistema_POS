package com.hexabyteit.api.pos.service;

import com.hexabyteit.api.pos.model.modelservice.ResponseListCompany;
import com.hexabyteit.api.pos.repository.CompanyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public ResponseListCompany getListCompanies(){
        log.info("Obtener companies");

        try{
            return ResponseListCompany.builder()
                    .companies(companyRepository.findAll())
                    .build();
        }catch (Exception ex){
            log.info("Error al obtener los datos de la companies de la base de datos");
            throw new RuntimeException("Error al obtener los datos de la companies de la base de datos");
        }
    }

}
