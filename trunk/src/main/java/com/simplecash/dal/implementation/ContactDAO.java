package com.simplecash.dal.implementation;

import com.simplecash.dal.SessionManager;
import com.simplecash.dal.declaration.IContactDAO;
import com.simplecash.object.Contact;
import org.hibernate.Session;

/**
 *
 */
public class ContactDAO implements IContactDAO {
    public Contact getById(long id) {
        Contact contact = null;
        Session session = SessionManager.getSessionFactory().openSession();
        try{
            contact = (Contact) session.get(Contact.class, id);
        } finally {
            session.close();
        }

        return contact;
    }

    public long save(Contact contact) {
        int id = -1;

        Session session = SessionManager.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.saveOrUpdate(contact);
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return id;
    }
}
