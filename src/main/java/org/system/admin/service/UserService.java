package org.system.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.system.role.model.Role;
import org.system.admin.model.User;
import org.system.admin.repository.UserRepository;
import org.system.role.repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private RoleRepository roleRepository;

    public void createUser(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
//        Role userRole = new Role("USER");
//        //Role userRole = roleRepository.findById(user.getRoles().get(0));
//        List<Role> roles = new ArrayList<>();
//        roles.add(userRole);
//        user.setRoles(roles);
        userRepository.save(user);
    }

    public void createAdmin(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = new Role("ADMIN");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
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
}
