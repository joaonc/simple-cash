package com.simplecash.dal;

import com.simplecash.dal.repository.BankRepository;
import com.simplecash.object.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Perform some database related operations.
 */
public class DatabaseManagerDAO {

    public void createDatabaseSchema() {
        // To not use the Configuration object below for SchemaExport, check out
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

        RepositoryFactory.getEntityManager().getTransaction().begin();
        BankRepository bankRepository = RepositoryFactory.getRepository(BankRepository.class);
        bankRepository.save(bank);
        bankRepository.flush();
        RepositoryFactory.getEntityManager().getTransaction().commit();
    }
}
