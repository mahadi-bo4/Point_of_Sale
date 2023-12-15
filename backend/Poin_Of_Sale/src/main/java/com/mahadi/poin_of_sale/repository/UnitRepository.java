package com.mahadi.poin_of_sale.repository;

import com.mahadi.poin_of_sale.model.product.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {
}
