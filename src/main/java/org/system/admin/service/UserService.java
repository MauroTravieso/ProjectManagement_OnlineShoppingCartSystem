package org.system.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.system.admin.model.UserStatus;
import org.system.permission.model.Permission;
import org.system.role.model.Role;
import org.system.admin.model.User;
import org.system.admin.repository.UserRepository;
import org.system.role.repository.RoleRepository;
import org.system.shoppingcart.model.Cart;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
//        Role userRole = new Role("USER");
//        //Role userRole = roleRepository.findById(user.getRoleName());
//        List<Role> roles = new ArrayList<>();
//        roles.add(userRole);
//        user.setRoles(roles);

        // Account creation date
        LocalDate accountCreatedDate = LocalDate.now();
        user.setAccountCreatedDate(accountCreatedDate);

        // User status assignation
        user.setStatus(UserStatus.PENDING);

        Permission userPermission0 = new Permission("NO_ACCESS_REPORT");
        Permission userPermission1 = new Permission("NO_UPLOAD_PRODUCT");
        Permission userPermission2 = new Permission("NO_UPDATE_PRODUCT");
        List<Permission> permissions = new ArrayList<>();
        permissions.add(userPermission0);
        permissions.add(userPermission1);
        permissions.add(userPermission2);
        user.setPermissions(permissions);

        // Vendor quota asssignation
        Role role = user.getRoles().get(0);
        System.out.println("***********************************");
        System.out.println(role.getName());
        if (role.getName().equals("VENDOR"))
            user.setQuota(5000.0);
        else
            user.setQuota(0.0);

        if (role.getName().equals("USER"))
            user.setCart(new Cart());

        System.out.println("Quota: "+user.getQuota());

        userRepository.save(user);
    }

    public void createAdmin(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));

        Role userRole = new Role("ADMIN");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);

        Permission userPermission0 = new Permission("ACCESS_REPORT");
        Permission userPermission1 = new Permission("UPLOAD_PRODUCT");
        Permission userPermission2 = new Permission("UPDATE_PRODUCT");
        List<Permission> permissions = new ArrayList<>();
        permissions.add(userPermission0);
        permissions.add(userPermission1);
        permissions.add(userPermission2);
        user.setPermissions(permissions);

        userRepository.save(user);
    }

    public User findOne(String email) {
        //return userRepository.findOne(email);
        return userRepository.getOne(email);
    }

    public boolean isUserPresent(String email) {
        //User u = userRepository.getOne(email);
        Optional<User> u = userRepository.findById(email);
        System.out.println(u);
        if (u.isPresent()) return true;
        return false;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findByName(String name) {
        return userRepository.findByNameLike("%"+name+"%");
    }

    public void approveUser(String email) {
        userRepository.approveUser(email);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User getUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    public int countLinesNumber(String email){
        return getUserByEmail(email).getCart().getLines().size();
    }
}
