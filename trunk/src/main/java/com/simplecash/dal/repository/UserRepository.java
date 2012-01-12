package com.simplecash.dal.repository;

import com.simplecash.object.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByName(String name);
}
