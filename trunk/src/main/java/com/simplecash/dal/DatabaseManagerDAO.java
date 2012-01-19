package com.simplecash.dal;

import com.simplecash.dal.repository.*;
import com.simplecash.object.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.transaction.annotation.Transactional;

/**
 * Perform some database related operations.
 */
public class DatabaseManagerDAO {

    @Autowired
    BankRepository bankRepository;

//    RepositoryFactorySupport factory;

    public void createDatabaseSchema() {
        // To not use the Configuration object below for SchemaExport, check out
        // http://hillert.blogspot.com/2010/05/using-hibernates-schemaexport-feature.html

        Configuration configuration = new Configuration();
        configuration.configure();

        SchemaExport schemaExport = new SchemaExport(configuration);
        schemaExport.drop(true, true);
        schemaExport.create(true, true);
    }

    public void updateDatabaseSchema() {

    }

    @Transactional
    public void populateWithTestData() {

        RepositoryFactory.getEntityManager().getTransaction().begin();

        ContactInfoTypeRepository contactInfoTypeRepository =
                RepositoryFactory.getRepository(ContactInfoTypeRepository.class);
        for (ContactInfoType.Type type : ContactInfoType.Type.values()) {
            ContactInfoType contactInfoType = new ContactInfoType(type);
            contactInfoTypeRepository.save(contactInfoType);
        }
        
        Bank bank = new Bank();
        bank.setName("Itau");
        bank.setCode("341");

        BankRepository bankRepository = RepositoryFactory.getRepository(BankRepository.class);
        bank = bankRepository.save(bank);

        BankAccount bankAccount = new BankAccount();
        bankAccount.setName("Conta no Itaú");
        bankAccount.setNumber("1234-01");
        bankAccount.setBank(bank);

        BankAccountRepository bankAccountRepository = RepositoryFactory.getRepository(BankAccountRepository.class);
        bankAccount = bankAccountRepository.save(bankAccount);

        RepositoryFactory.getEntityManager().getTransaction().commit();
    }
}
