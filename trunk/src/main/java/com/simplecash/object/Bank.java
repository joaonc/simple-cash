package com.simplecash.object;

import javax.persistence.Entity;

/**
 * Bank pojo.
 */
@Entity
public class Bank {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
