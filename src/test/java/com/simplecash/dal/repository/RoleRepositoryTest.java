package com.simplecash.dal.repository;

import com.simplecash.object.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * Unit tests for RoleRepository.
 * These tests change the database and should never be run against production.
 */
@ContextConfiguration("classpath:application-context-test.xml")
public class RoleRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    RoleRepository roleRepository;

    @Test
    public void findAllTest() {
        Iterable<Role> banks = roleRepository.findAll();
        assertNotNull(banks);
    }
}
