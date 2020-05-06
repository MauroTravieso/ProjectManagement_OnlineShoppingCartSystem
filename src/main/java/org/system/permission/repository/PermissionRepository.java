package org.system.permission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.system.admin.model.User;
import org.system.permission.model.Permission;
import org.system.task.model.Task;

import java.util.List;

/**
 * Application Permission Repository.
 *
 * Bugs: none known
 *
 * @author       Team II APR2020 - Mauro Travieso (986965)
 * @version      1.0
 *
 */
@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {

    @Query("select p from Permission p")

    List<Permission> findUser();

    List<User> findByNameLike(String s);

}
