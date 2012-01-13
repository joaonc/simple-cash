package com.simplecash.dal.repository;

import com.simplecash.object.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 */
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    public Supplier findByName(String name);
}