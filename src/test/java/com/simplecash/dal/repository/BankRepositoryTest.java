package com.simplecash.dal.repository;

import com.simplecash.object.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * Unit tests for BankRepository.
 */
@ContextConfiguration("classpath:application-context-test.xml")
public class BankRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    BankRepository bankRepository;

    @BeforeTransaction
    public void setupData() throws Exception {

//        if (countRowsInTable("Customer") == 0) {
//            executeSqlScript("classpath:data.sql", false);
//        }
    }

    @Test
    public void getByIdTest() {
        Iterable<Bank> banks = bankRepository.findAll();
        assertNotNull(banks);
    }
}
