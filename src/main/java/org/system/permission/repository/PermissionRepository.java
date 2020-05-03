package org.system.permission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.system.admin.model.User;
import org.system.permission.model.Permission;
import org.system.task.model.Task;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {

    //@Query("select p from Permission p where p<>'NO_ACCESS_REPORT' or p<>'NO_UPLOAD_PRODUCT' or p<>'NO_UPDATE_PRODUCT'")

//    @Query("delete from Permission WHERE name='NO_ACCESS_REPORT' or name='NO_UPLOAD_PRODUCT' or name='NO_UPDATE_PRODUCT'")
    @Query("select p from Permission p")

    List<Permission> findUser();

    List<User> findByNameLike(String s);

    //
    //List<Permission> findByUser(User user);

    //List<Permission> findPermissionsByEmail(String email);
}
