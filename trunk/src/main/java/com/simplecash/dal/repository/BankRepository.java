package com.simplecash.dal.repository;

import com.simplecash.object.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 */
public interface BankRepository extends JpaRepository<Bank, Long> {

    public Bank findByName(String name);
}
