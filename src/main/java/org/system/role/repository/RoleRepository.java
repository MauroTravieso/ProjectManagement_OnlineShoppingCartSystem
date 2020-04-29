package org.system.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.system.role.model.Role;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

    @Query("select r from Role r where r.name<>'ADMIN'")

    List<Role> findUser();
    //Role findById(Role role);
}
