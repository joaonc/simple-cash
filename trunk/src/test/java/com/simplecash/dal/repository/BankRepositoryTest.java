package com.simplecash.dal.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import org.junit.*;
import static org.junit.Assert.*;
import com.jjcommon.*;

import com.simplecash.object.*;

/**
 * Unit tests for BankRepository.
 * These tests change the database and should never be run against production.
 */
//@Transactional
//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context-test.xml")
public class BankRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    BankRepository bankRepository;

    @BeforeTransaction
    public void setupData() throws Exception {
        if (countRowsInTable("Bank") == 0) {
            executeSqlScript("classpath:data.sql", false);
        }
    }

    @Test
    public void findAllTest() {
        Iterable<Bank> banks = bankRepository.findAll();
        assertNotNull(banks);
    }
    
    @Test
//    @Transactional
    public void createTest() {
        Bank bank = new Bank();
        
        bank.setName(JJStringUtils.createRandom(5));
        bank.setCode(JJStringUtils.createRandom(5));

        bank = bankRepository.saveAndFlush(bank);
        bankRepository.flush();
        Bank persisted = bankRepository.findOne(bank.getId());
        bankRepository.count();

        //assertNotSame(bank, persisted);
        assertEquals(bank.getName(), persisted.getName());
        assertEquals(bank.getCode(), persisted.getCode());
    }
}
