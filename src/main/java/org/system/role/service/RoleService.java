package org.system.role.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.system.admin.model.User;
import org.system.role.model.Role;
import org.system.role.repository.RoleRepository;

import java.util.List;
/**
 *  Service
 *
 * Bugs: none known
 *
 * @author       Dinh Nguyen (986520) - Team II APR2020
 * @version      1.0
 *
 */
@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public void save(List<Role> role) {
        roleRepository.saveAll(role);
    }

    public List<Role> findUser() {
        return roleRepository.findUser();
    }

//    public List<User> findByRole(String name) {
//        return roleRepository.findByNameLike("%"+name+"%");
//    }


}
