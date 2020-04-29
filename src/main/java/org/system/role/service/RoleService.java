package org.system.role.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.system.role.model.Role;
import org.system.role.repository.RoleRepository;

import java.util.List;

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
}
