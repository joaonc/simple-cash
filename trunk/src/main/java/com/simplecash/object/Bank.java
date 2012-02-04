package com.simplecash.object;

import javax.persistence.*;
//import javax.validation.constraints.*;

/**
 * Bank pojo.
 */
@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Basic(optional = false)
    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true)
    private String code;

    public Bank() {
    }

    public Bank(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
