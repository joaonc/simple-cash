package com.simplecash.dal.repository;

import com.simplecash.object.ExpenseAccount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 */
public interface ExpenseAccountRepository extends JpaRepository<ExpenseAccount, Long> {

    public ExpenseAccount findByName(String name);
}
