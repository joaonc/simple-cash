package com.simplecash.dal.repository;

import com.simplecash.object.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 */
public interface TagRepository extends JpaRepository<Tag, Long> {

    public Tag findByName(String name);
}