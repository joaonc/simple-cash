package com.simplecash.dal.repository;

import com.simplecash.object.*;
import org.junit.*;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.BeforeTransaction;

import java.util.List;

/**
 * Unit tests for ContactRepository.
 * These tests change the database and should never be run against production.
 */
@ContextConfiguration("classpath:application-context-test.xml")
public class ContactRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    ContactRepository contactRepository;

    @BeforeTransaction
    public void setupData() throws Exception {
        if (countRowsInTable("Contact") == 0) {
            executeSqlScript("classpath:data.sql", false);
        }
    }

    @Test
    public void findAllTest() {
        List<Contact> contacts = contactRepository.findAll();
        assertNotNull(contacts);
        assertTrue(contacts.size() > 0);
    }

    @Test
    public void createSimpleContactTest() {
        String name = "Mr Bean";

        Contact contact = new Contact();
        contact.setName(name);
        contact = contactRepository.save(contact);
        assertTrue(contact.getId() > 0);

        Contact contact2 = contactRepository.findByName(name);
        assertNotNull(contact2);
    }

    @Test
    public void createContactWithAddressTest() {
        String name = "Mr Bean With Address";

        Address address = new Address();
        address.setAddress1("123 Main St, Unit 4");
        address.setState("WA");

        Contact contact = new Contact();
        contact.setName(name);
        contact.addAddress(address);
        assertNotNull(contact.getAddresses());

        contact = contactRepository.save(contact);
        assertTrue(contact.getId() > 0);
        assertEquals(contact.getAddresses().size(), 1);
        assertTrue(contact.getAddresses().iterator().next().getId() > 0);
    }

    @Test
    public void createContactWithContactInfoTest() {
        String name = "Mr Bean With ContactInfo";

        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setContactInfoType(ContactInfoType.Type.Email);
        contactInfo.setType("Work");
        contactInfo.setValue("bean@beanemail.com");

        Contact contact = new Contact();
        contact.setName(name);
        contact.addContactInfo(contactInfo);
        assertNotNull(contact.getContactInfos());

        contact = contactRepository.save(contact);
        assertTrue(contact.getId() > 0);
        assertEquals(contact.getContactInfos().size(), 1);
        assertTrue(contact.getContactInfos().iterator().next().getId() > 0);
    }
}
