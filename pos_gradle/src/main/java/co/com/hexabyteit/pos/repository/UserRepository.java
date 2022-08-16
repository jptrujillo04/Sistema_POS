package co.com.hexabyteit.pos.repository;

import co.com.hexabyteit.pos.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    public UserEntity findByAccount(String account);
}
