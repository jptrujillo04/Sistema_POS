package co.com.hexabyteit.pos.repository;

import co.com.hexabyteit.pos.model.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {
}
