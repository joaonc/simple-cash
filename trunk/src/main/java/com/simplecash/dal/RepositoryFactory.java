package com.simplecash.dal;

import com.simplecash.dal.repository.BankRepository;
import com.simplecash.dal.repository.ContactRepository;
import com.simplecash.object.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.orm.jpa.JpaTransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 */
public class RepositoryFactory {

    private static RepositoryFactorySupport repositoryFactory;
    private static EntityManager entityManager;

    static {

        ApplicationContext context = new ClassPathXmlApplicationContext("application-context-prod.xml");
        JpaTransactionManager transactionManager = (JpaTransactionManager) context.getBean("transactionManager");
        EntityManagerFactory entityManagerFactory = transactionManager.getEntityManagerFactory();
        entityManager = entityManagerFactory.createEntityManager();
        repositoryFactory = new JpaRepositoryFactory(entityManager);

    }

    public static RepositoryFactorySupport getInstance() {

        return repositoryFactory;
    }

    public static EntityManager getEntityManager() {

        return entityManager;
    }

    public static <T extends Repository<?, ?>> T getRepository(Class<T> repositoryInterface) {

        return getInstance().getRepository(repositoryInterface);
    }
}
