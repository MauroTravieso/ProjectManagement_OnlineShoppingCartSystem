package org.system.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.system.admin.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    List<User> findByNameLike(String name);

}
