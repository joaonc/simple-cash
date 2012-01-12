package com.simplecash.dal.repository;

import com.simplecash.object.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * Unit tests for BankRepository.
 */
@ContextConfiguration("classpath:application-context-test.xml")
public class BankRepositoryTest {

    @Autowired
    BankRepository bankRepository;

    @Test
    public void getByIdTest() {
        Iterable<Bank> banks = bankRepository.findAll();
        assertNotNull(banks);
    }
}
