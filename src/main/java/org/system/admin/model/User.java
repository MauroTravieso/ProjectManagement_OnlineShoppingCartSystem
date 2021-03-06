package org.system.admin.model;

//import org.hibernate.validator.constraints.Email;
//import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;
import org.system.permission.model.Permission;
import org.system.role.model.Role;
import org.system.shoppingcart.model.Cart;
import org.system.task.model.Task;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Application User Model.
 *
 * Bugs: none known
 *
 * @author       Team II APR2020 - Mauro Travieso (986965)
 * @version      1.0
 *
 */

@Data
@Entity
public class User {

    @Id
    @Email(message = "Email should be valid")
    @NotEmpty
    @Column(unique=true)
    private String email;

    @NotEmpty
    @Pattern(regexp = "([A-Z][a-z]+)")
    private String firstName;

    @NotEmpty
    @Pattern(regexp = "([A-Z][a-z]+)")
    private String lastName;

    @NotEmpty
    @Size(min=10, max=12)
    @Pattern(regexp = "^\\(?([0-8]{1}[1-8]{1}[1-9]{1})\\)?[-.●]?([0-9]{3})[-.●]?([0-9]{4})$", message="Invalid number")
    private String phoneNumber;

    private LocalDate accountCreatedDate = LocalDate.now();

    private LocalDate statusChangedDate;

    @Size(min=4)
    private String password;

    private UserStatus status;

    private double quota;

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<Task> tasks;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="USER_ROLES", joinColumns = {@JoinColumn(name="USER_EMAIL", referencedColumnName = "email")},
                                  inverseJoinColumns = {@JoinColumn(name="ROLE_NAME", referencedColumnName = "name")})
    private List<Role> roles;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="USER_PERMISSIONS", joinColumns = {@JoinColumn(name="USER_EMAIL", referencedColumnName = "email")},
            inverseJoinColumns = {@JoinColumn(name="PERMISSION_NAME", referencedColumnName = "name")})
    private List<Permission> permissions;

    @Transient
    private String retypePassword;

    @Transient
    private Role roleName;

    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;

    public String getRoleName() {
        return roles.get(0).getName();
    }

    @Transient
    private UserStatus stats;

    public String getUserStatus() {
        return status.toString();
    }

    public User() {
    }

    @Transient
    private Permission perms;

    public String getPerms() {
        return permissions.get(0).getName();
    }


    public User(String email, String firstName, String lastName, String phoneNumber, LocalDate accountCreatedDate, String password, List<Role> role, UserStatus status, Double quota) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.accountCreatedDate = accountCreatedDate;
        this.password = password;
        this.roles = role;
        this.status = status;
        this.quota = quota;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
