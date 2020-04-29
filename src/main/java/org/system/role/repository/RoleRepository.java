package org.system.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.system.role.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

    //Role findById(Role role);
}
