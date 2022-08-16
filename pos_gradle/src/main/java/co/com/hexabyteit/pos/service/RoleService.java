package co.com.hexabyteit.pos.service;

import co.com.hexabyteit.pos.model.service.ResponseListRole;
import co.com.hexabyteit.pos.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public ResponseListRole getListRole(){
        log.info("Obtener roles");

        try{
            return ResponseListRole.builder()
                    .roles(roleRepository.findAll())
                    .build();
        }catch (Exception ex){
            log.info("Error al obtener los datos del rol de la base de datos");
            throw new RuntimeException("Error al obtener los datos del rol de la base de datos");
        }
    }
}
