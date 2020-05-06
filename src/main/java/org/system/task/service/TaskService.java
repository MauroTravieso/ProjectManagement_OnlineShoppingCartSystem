package org.system.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.system.task.model.Task;
import org.system.admin.model.User;
import org.system.task.repository.TaskRepository;

import java.util.List;

/**
 * Application Task Service.
 *
 * Bugs: none known
 *
 * @author       Team II APR2020 - Mauro Travieso (986965)
 * @version      1.0
 *
 */
@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void addTask(Task task, User user) {
        task.setUser(user);
        taskRepository.save(task);
    }

    // Return the list of tasks assigned to a particular user
    public List<Task> findUserTask(User user) {
        return taskRepository.findByUser(user);
    }

}
