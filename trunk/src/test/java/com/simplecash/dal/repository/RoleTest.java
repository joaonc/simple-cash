package com.simplecash.dal.repository;

import com.simplecash.object.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * Unit tests for BankRepository.
 */
@ContextConfiguration("classpath:application-context-test.xml")
public class RoleTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    RoleRepository roleRepository;

    @Test
    public void findAllTest() {
        Iterable<Role> banks = roleRepository.findAll();
        assertNotNull(banks);
    }
}
