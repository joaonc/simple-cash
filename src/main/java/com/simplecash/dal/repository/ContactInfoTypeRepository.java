package com.simplecash.dal.repository;

import com.simplecash.object.ContactInfoType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface ContactInfoTypeRepository extends JpaRepository<ContactInfoType, Long> {
}
