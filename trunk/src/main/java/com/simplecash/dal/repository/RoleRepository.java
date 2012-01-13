package com.simplecash.dal.repository;

import com.simplecash.object.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    public Role findByName(String name);
}
