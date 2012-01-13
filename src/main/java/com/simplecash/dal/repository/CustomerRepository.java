package com.simplecash.dal.repository;

import com.simplecash.object.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    public Customer findByName(String name);
}