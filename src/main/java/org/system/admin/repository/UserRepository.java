package org.system.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.system.admin.model.User;

import java.util.List;

/**
 * Application User Repository.
 *
 * Bugs: none known
 *
 * @author       Team II APR2020 - Mauro Travieso (986965)
 * @version      1.0
 *
 */

public interface UserRepository extends JpaRepository<User, String> {

    @Query("select u from User u where u.firstName like %?1% or u.lastName like %?1%")
    List<User> findByNameLike(String name);
    User findUserByEmail(String email);

}
