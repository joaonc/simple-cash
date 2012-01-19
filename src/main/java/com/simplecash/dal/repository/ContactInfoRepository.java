package com.simplecash.dal.repository;

import com.simplecash.object.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface ContactInfoRepository extends JpaRepository<ContactInfo, Long> {
}
