package co.com.hexabyteit.pos.repository;

import co.com.hexabyteit.pos.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
