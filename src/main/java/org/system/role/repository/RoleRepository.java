package org.system.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.system.admin.model.User;
import org.system.role.model.Role;

import java.util.List;
/**
 *
 *
 * Bugs: none known
 *
 * @author       Dinh Nguyen (986520) - Team II APR2020
 * @version      1.0
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

    @Query("select r from Role r where r.name<>'ADMIN'")

    List<Role> findUser();

    List<User> findByNameLike(String s);
    //Role findById(Role role);
}
