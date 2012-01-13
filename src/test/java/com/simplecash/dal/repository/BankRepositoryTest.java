package com.simplecash.dal.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.util.StringUtils;

import org.junit.*;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import com.simplecash.object.*;
import com.jjcommon.*;

/**
 * Unit tests for BankRepository.
 * Note that some of these tests change the database and should never be run against production.
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
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
        
        bank.setName(StringUtil.createRandom(10));
        bank.setCode(StringUtil.createRandom(10));

        bank = bankRepository.saveAndFlush(bank);
        bankRepository.flush();
        Bank persisted = bankRepository.findOne(bank.getId());

        //assertNotSame(bank, persisted);
        assertEquals(bank.getName(), persisted.getName());
        assertEquals(bank.getCode(), persisted.getCode());
    }
}
