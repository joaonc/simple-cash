package com.simplecash.dal.repository;

import com.simplecash.object.*;
import org.junit.*;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.BeforeTransaction;

/**
 * Unit tests for ContactInfoRepository.
 * These tests change the database and should never be run against production.
 */
@ContextConfiguration("classpath:application-context-test.xml")
public class ContactInfoRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    ContactInfoRepository contactInfoRepository;

    @BeforeTransaction
    public void setupData() throws Exception {
        if (countRowsInTable("Contact") == 0) {
            executeSqlScript("classpath:data.sql", false);
        }
    }

    @Test
    public void createSimpleContactInfoTest() {
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setContactInfoType(ContactInfoType.Type.Email);
        contactInfo.setType("Work");
        contactInfo.setValue("bean@beanemail.com");

        contactInfo = contactInfoRepository.save(contactInfo);
        assertTrue(contactInfo.getId() > 0);
    }
}
