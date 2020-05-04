package org.system.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.system.admin.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    @Query("select u from User u where u.firstName like %?1% or u.lastName like %?1%")
    List<User> findByNameLike(String name);

    //@Query("update User u SET u.firstName='Mauro' WHERE u.email=:email")
    //void approveUser(String email);
}
