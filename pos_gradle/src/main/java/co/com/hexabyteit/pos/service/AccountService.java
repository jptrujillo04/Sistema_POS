package co.com.hexabyteit.pos.service;

import co.com.hexabyteit.pos.model.UserEntity;
import co.com.hexabyteit.pos.model.service.ResponseAccount;
import co.com.hexabyteit.pos.model.service.ResponseListUser;
import co.com.hexabyteit.pos.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AccountService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    public ResponseListUser getListUsuarios(){
        log.info("Obtener usuarios");

        try{
            return ResponseListUser.builder()
                    .users(userRepository.findAll())
                    .build();
        }catch (Exception ex){
            log.info("Error al obtener los datos del usuario de la base de datos");
            throw new RuntimeException("Error al obtener los datos del usuario de la base de datos");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        log.info("Obtener account");

        try{
            UserEntity user = userRepository.findByAccount(account);

            if (user == null){
                log.info("Cuenta de usuario no encontrada ==> (",account,")");
                throw new UsernameNotFoundException("Error la cuenta "+ account+ " no existe en la base de datos" );
            }
            log.info("Cuenta de usuario encontrada ==> (",account,")");
            boolean statusUser = (user.getStatus().equals("ACT"))?true:false;
            List<GrantedAuthority> grantedAuthorities = user.getRoles()
                    .stream()
                    .map(roleEntity -> new SimpleGrantedAuthority(roleEntity.getRoleName()))
                    .collect(Collectors.toList());
            return new User(user.getAccount(), user.getPassword(), statusUser, true, true, true, grantedAuthorities);
        }catch (Exception ex){
            log.info("Error al obtener los datos del account de la base de datos");
            throw new RuntimeException("Error al obtener los datos del account de la base de datos");
        }
    }
}
