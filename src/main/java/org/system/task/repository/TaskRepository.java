package org.system.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.system.task.model.Task;
import org.system.admin.model.User;

import java.util.List;
/**
 * Task Repository.
 *
 * Bugs: none known
 *
 * @author       Team II APR2020 - Jean Octavius (986988)
 * @version      1.0
 *
 */
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUser(User user);

}
