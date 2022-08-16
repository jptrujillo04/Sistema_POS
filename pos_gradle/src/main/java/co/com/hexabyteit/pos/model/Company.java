package co.com.hexabyteit.pos.model;

import co.com.hexabyteit.pos.model.constant.CompanyConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder(toBuilder = true)
@Table(name = CompanyConstant.TABLE_ORDER, schema="sispos")
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_company")
    private Long idCompany;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "status")
    private String status;

    @Column(name = "nit")
    private String nit;

    @Column(name = "verification_digit")
    private String verificationDigit;
}
