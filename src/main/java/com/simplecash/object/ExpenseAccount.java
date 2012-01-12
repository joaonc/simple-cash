package com.simplecash.object;

import javax.persistence.*;

/**
 * ExpenseAccount POJO
 */
@Entity
public class ExpenseAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
