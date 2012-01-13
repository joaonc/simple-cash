package com.simplecash.dal.repository;

import com.simplecash.object.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 */
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    public BankAccount findByName(String name);
}
