package com.simplecash.dal.declaration;

import com.simplecash.object.Contact;

/**
 * Interface declaration for ContactDAO
 */
public interface IContactDAO {
    public Contact getById(long id);
}
