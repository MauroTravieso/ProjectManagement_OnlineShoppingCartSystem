package org.system.admin.model;

//import org.hibernate.validator.constraints.Email;
//import org.hibernate.validator.constraints.NotEmpty;

import org.system.role.model.Role;
import org.system.task.model.Task;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class User {

    @Id
    @Email
    @NotEmpty
    @Column(unique=true)
    private String email;
    @NotEmpty
    private String name;
    @Size(min=4)
    private String password;
    private UserStatus status;

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<Task> tasks;
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="USER_ROLES", joinColumns = {@JoinColumn(name="USER_EMAIL", referencedColumnName = "email")},
                                  inverseJoinColumns = {@JoinColumn(name="ROLE_NAME", referencedColumnName = "name")})
    private List<Role> roles;

    @Transient
    private Role roleName;

    public String getRoleName() {
        return roles.get(0).getName();
    }

    @Transient
    private UserStatus stat;

    public String getUserStatus() {
        return stat.toString();
    }

    public User() {
    }

    public User(String email, String name, String password, List<Role> role, UserStatus status) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.status = status;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
