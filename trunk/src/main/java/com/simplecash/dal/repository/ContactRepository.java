package com.simplecash.dal.repository;

import com.simplecash.object.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 */
public interface ContactRepository extends JpaRepository<Contact, Long> {

    public Iterable<Contact> findByName(String name);
    public Iterable<Contact> findByPostalCode(String postalCode);
    public Iterable<Contact> findByState(String state);
}
