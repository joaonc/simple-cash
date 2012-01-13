package com.simplecash.dal;

import com.simplecash.dal.repository.BankRepository;
import com.simplecash.object.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Perform some database related operations.
 */
public class DatabaseManagerDAO {

    public void createDatabaseSchema() {
        // To not use the Configuration object below
        // Using Hibernate's SchemaExport Feature from within a Spring/JPA Context
        // http://hillert.blogspot.com/2010/05/using-hibernates-schemaexport-feature.html

        Configuration configuration = new Configuration();
        configuration.configure();

        SchemaExport schemaExport = new SchemaExport(configuration);
        schemaExport.create(true, true);
    }

    public void updateDatabaseSchema() {

    }

    public void populateWithTestData() {

        Bank bank = new Bank();
        bank.setName("ContentName");
        bank.setCode("ContentCode");

        BankRepository bankRepository = RepositoryFactory.getRepository(BankRepository.class);
        bankRepository.saveAndFlush(bank);
    }

}
