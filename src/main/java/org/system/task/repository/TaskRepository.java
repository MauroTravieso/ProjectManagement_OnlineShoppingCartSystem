package org.system.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.system.task.model.Task;
import org.system.admin.model.User;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUser(User user);

}
