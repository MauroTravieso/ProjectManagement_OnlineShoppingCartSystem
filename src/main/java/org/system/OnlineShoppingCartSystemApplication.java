package org.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.system.admin.model.User;
import org.system.admin.model.UserStatus;
import org.system.admin.service.UserService;
import org.system.role.model.Role;
import org.system.role.service.RoleService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//@SpringBootApplication
//public class SocialApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(SocialApplication.class, args);
//	}
//
//}

@SpringBootApplication
public class OnlineShoppingCartSystemApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	public static void main(String[] args) {
		SpringApplication.run(OnlineShoppingCartSystemApplication.class, args);
	}

	@Override
	public void run(String...args) throws Exception {
		List<Role> roles = new ArrayList<>();
		//roles.add(new Role("ADMIN"));
		roles.add(new Role("VENDOR"));
		roles.add(new Role("EMPLOYEE"));
		roles.add(new Role("CUSTOMER"));
		roles.add(new Role("END-USER"));

		roleService.save(roles);

		List<Role> rolesAdmin = new ArrayList<>();
		rolesAdmin.add(new Role("ADMIN"));

		UserStatus status = UserStatus.ACTIVE;

		LocalDate accountCreatedDate = LocalDate.now();

		User newAdmin = new User("admin@mail.com", "Admin", "Admin", "0123456789", accountCreatedDate,"admin",  rolesAdmin, status, 0.0);
		userService.createAdmin(newAdmin);
	}
}
