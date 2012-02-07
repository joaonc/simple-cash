package com.simplecash.dal.repository;

import com.simplecash.object.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 */
public interface ContactRepository extends JpaRepository<Contact, Long> {

    public List<Contact> findByName(String name);
}
