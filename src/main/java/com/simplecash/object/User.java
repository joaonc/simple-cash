package com.simplecash.object;

import javax.persistence.*;
import java.util.List;

/**
 * Application user.
 */
@Entity
public class User {
    @Id
    private long id;
    private String name;
    private String login;
    private String password;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="roles_fk")
    private List<Role> roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
