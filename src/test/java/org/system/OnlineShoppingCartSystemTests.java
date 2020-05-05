package org.system;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.system.admin.model.UserStatus;
import org.system.role.model.Role;
import org.system.shoppingcart.model.Cart;
import org.system.task.service.TaskService;
import org.system.admin.service.UserService;
import org.system.task.model.Task;
import org.system.admin.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OnlineShoppingCartSystemTests {

	@Autowired
	private UserService userService;
	@Autowired
	private TaskService taskService;

	@Before
	public void initDb() {
		{
			List<Role> rolesUser = new ArrayList<>();
			rolesUser.add(new Role("USER"));
			LocalDate accountCreatedDate = LocalDate.now();
			LocalDate statusChangedDate = LocalDate.now();
			Cart cart = new Cart();

//			User newUser = new User("testUser@mail.com", "testUser", "testUser", "0123456789",accountCreatedDate,"123456", rolesUser, UserStatus.PENDING,0.0, statusChangedDate, cart );
			User newUser = new User("testUser@mail.com", "testUser", "testUser", "0123456789",accountCreatedDate,"123456", rolesUser, UserStatus.PENDING,0.0);

			userService.createUser(newUser);
		}
		{
			List<Role> rolesAdmin = new ArrayList<>();
			rolesAdmin.add(new Role("ADMIN"));
			LocalDate accountCreatedDate = LocalDate.now();
			LocalDate statusChangedDate = LocalDate.now();
			Cart cart = new Cart();

//			User newUser = new User("testAdmin@mail.com", "testAdmin", "testAdmin", "0123456789", accountCreatedDate,"123456", rolesAdmin, UserStatus.ACTIVE,0.0, statusChangedDate, cart );
			User newUser = new User("testAdmin@mail.com", "testAdmin", "testAdmin", "0123456789", accountCreatedDate,"123456", rolesAdmin, UserStatus.ACTIVE,0.0);
			userService.createUser(newUser);
		}

		Task userTask = new Task("03/01/2020", "00:11","11:00", "You need to work today.");
		User user = userService.findOne("testUser@mail.com");
		taskService.addTask(userTask, user);
	}

	@Test
	public void testUser() {
		User user = userService.findOne("testUser@mail.com");
		assertNotNull(user);
		User admin = userService.findOne("testAdmin@mail.com");
		assertEquals(admin.getEmail(), "testAdmin@mail.com");
	}

	@Test
	public void testTask() {
		User user = userService.findOne("testUser@mail.com");
		List<Task> task = taskService.findUserTask(user);
		assertNotNull(task);
	}

}
