package com.simplecash.dal.implementation;

import com.simplecash.object.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import java.util.Date;

/**
 *
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
        Contact contact = new Contact();
        contact.setCreateDate(new Date());
        //new ContactDAO().save(contact);
    }

}
