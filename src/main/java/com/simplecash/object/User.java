package com.simplecash.object;

import javax.persistence.*;
import java.util.Collection;

/**
 * Application user.
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="roles_fk")
//    private Iterable<Role> roles;

    private String name;
    private String login;
    private String password;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Iterable<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Iterable<Role> roles) {
//        this.roles = roles;
//    }
}
