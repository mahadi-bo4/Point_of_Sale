package com.mahadi.poin_of_sale.repository;

import com.mahadi.poin_of_sale.model.grn.GrnPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrnPaymentRepository extends JpaRepository<GrnPayment, Long> {
}
