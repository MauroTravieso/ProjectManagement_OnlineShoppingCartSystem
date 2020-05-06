package org.system.permission.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.system.admin.model.User;
import org.system.permission.model.Permission;
import org.system.permission.repository.PermissionRepository;
import org.system.task.model.Task;

import java.util.List;

/**
 * Application Permission Service.
 *
 * Bugs: none known
 *
 * @author       Team II APR2020 - Mauro Travieso (986965)
 * @version      1.0
 *
 */

@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    public List<Permission> findAll() { return permissionRepository.findAll(); }

    public void save(List<Permission> permission) {
        permissionRepository.saveAll(permission);
    }

    public List<Permission> findUser() {return permissionRepository.findUser(); }

}
