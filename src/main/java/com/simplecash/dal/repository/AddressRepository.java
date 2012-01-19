package com.simplecash.dal.repository;

import com.simplecash.object.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 */
public interface AddressRepository extends JpaRepository<Address, Long> {

    public Address findByName(String name);
}
