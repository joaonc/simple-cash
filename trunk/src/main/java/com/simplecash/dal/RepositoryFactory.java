package com.simplecash.dal;

import com.simplecash.dal.repository.BankRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 */
public class RepositoryFactory {
    private static JpaRepositoryFactory repositoryFactory;
    private static EntityManager entityManager;

    static {

        ApplicationContext context = new ClassPathXmlApplicationContext("application-context-prod.xml");
        EntityManagerFactory entityManagerFactory = (EntityManagerFactory) context.getBean("entityManagerFactory");
        entityManager = entityManagerFactory.createEntityManager();
        repositoryFactory = new JpaRepositoryFactory(entityManager);
    }

    public static JpaRepositoryFactory getInstance() {
        return repositoryFactory;
    }
    public static <T extends Repository<?, ?>> T getRepository(Class<T> repositoryInterface) {

        return getInstance().getRepository(repositoryInterface);
    }

    public static void flush() {

        entityManager.flush();
    }
}
