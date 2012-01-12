package com.simplecash.object;

import javax.persistence.*;

/**
 * Supplier pojo.
 */
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    Contact contact;

}
