package co.com.hexabyteit.pos.service;

import co.com.hexabyteit.pos.model.service.ResponseListCompany;
import co.com.hexabyteit.pos.repository.CompanyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
