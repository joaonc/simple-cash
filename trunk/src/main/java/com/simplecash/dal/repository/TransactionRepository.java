package com.simplecash.dal.repository;

import com.simplecash.object.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 */
public interface TransactionRepository extends JpaRepository<Contact, Long> {
}
