package org.system.permission.model;

import org.system.admin.model.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Permission {

    @Id
    private String name;

    @ManyToMany(mappedBy="permissions")
    private List<User> users;

    public Permission() {
    }

    public Permission(String name) {
        this.name = name;
    }

    public Permission(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
