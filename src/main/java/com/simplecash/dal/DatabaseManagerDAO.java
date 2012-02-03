package com.simplecash.dal;

import com.simplecash.dal.repository.*;
import com.simplecash.exception.DbSchemaException;
import com.simplecash.object.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

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

    /**
     * Populates the database with required data, especially static tables.
     */
    public  void populateWithRequiredData() throws DbSchemaException {

        RepositoryFactory.getEntityManager().getTransaction().begin();

        // Version information
        DbInfo dbInfo = new DbInfo();
        dbInfo.setMajor(1);
        dbInfo.setMinor(0);

        DbInfoRepository dbInfoRepository = RepositoryFactory.getRepository(DbInfoRepository.class);
        List<DbInfo> currentDbInfos = dbInfoRepository.findAll(new Sort(
                new Sort.Order(Sort.Direction.DESC, "dateImplemented")));  // Order by dateImplemented, most recent first

        if (currentDbInfos == null || currentDbInfos.size() == 0) {
            dbInfoRepository.save(dbInfo);
        } else {
            DbInfo currentDbInfo = currentDbInfos.get(0);  // The most recent one
            int dbComparison = dbInfo.compareTo(currentDbInfo);
            if (dbComparison == 1) {
                // TODO: Trigger db update
                dbInfoRepository.save(dbInfo);
            } else if (dbComparison == -1) {
                throw new DbSchemaException(String.format(
                        "Database version is higher than what the application supports.\n" +
                        "DB version: %s, Application: %s", currentDbInfo, dbInfo));
            }
        }

        // ContactInfoType
        ContactInfoTypeRepository contactInfoTypeRepository = RepositoryFactory.getRepository(ContactInfoTypeRepository.class);

        List<ContactInfoType> contactInfoTypes = new LinkedList<ContactInfoType>();
        for(ContactInfoType.Type type : ContactInfoType.Type.values()) {
            ContactInfoType contactInfoType = new ContactInfoType(type);
            if (contactInfoTypeRepository.getByIdType(contactInfoType.getType().getId()) == null) {
                contactInfoTypes.add(contactInfoType);
            }
        }
        if (contactInfoTypes.size() > 0) {
            contactInfoTypeRepository.save(contactInfoTypes);
        }

        RepositoryFactory.getEntityManager().getTransaction().commit();
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
