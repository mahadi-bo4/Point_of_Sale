package com.mahadi.poin_of_sale.repository;

import com.mahadi.poin_of_sale.model.supplier.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Page<Company> findByEmailContainingOrNameContainingOrMobileContaining(String email, String name, String mobile, PageRequest pr);

    boolean existsByEmailOrNameOrMobile(String email, String name, String mobile);
}
