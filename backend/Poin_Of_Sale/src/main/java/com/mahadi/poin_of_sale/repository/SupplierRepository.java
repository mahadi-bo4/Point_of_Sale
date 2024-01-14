package com.mahadi.poin_of_sale.repository;

import com.mahadi.poin_of_sale.model.supplier.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Page<Supplier> findByEmailContainingOrNameContainingOrMobileContaining(String email, String name, String mobile, PageRequest pr);

    boolean existsByEmailAndMobile(String email, String mobile);
}
