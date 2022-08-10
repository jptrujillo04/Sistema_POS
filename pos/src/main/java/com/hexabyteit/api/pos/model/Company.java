package com.hexabyteit.api.pos.model;

import com.hexabyteit.api.pos.model.constant.CompanyConstant;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Builder(toBuilder = true)
@Table(name = CompanyConstant.TABLE_ORDER, schema="sispos")
public class Company {

    private Long idCompany;
    private String companyName;
    private String status;
    private String nit;
    private String verificationDigit;
}
