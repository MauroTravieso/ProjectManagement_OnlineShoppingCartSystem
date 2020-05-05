package org.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.system.admin.model.User;
import org.system.admin.model.UserStatus;
import org.system.admin.service.UserService;
import org.system.product.model.Product;
import org.system.product.service.ProductService;
import org.system.permission.model.Permission;
import org.system.permission.service.PermissionService;
import org.system.role.model.Role;
import org.system.role.service.RoleService;
import org.system.shoppingcart.model.Cart;

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

	@Autowired
	private PermissionService permissionService;

	@Autowired
    private ProductService productService;

    public static void main(String[] args) {
        SpringApplication.  run(OnlineShoppingCartSystemApplication.class, args);
    }

    @Override
	public void run(String...args) throws Exception {

		// Roles definition
		List<Role> roles = new ArrayList<>();
		roles.add(new Role("ADMIN"));
		roles.add(new Role("VENDOR"));
		roles.add(new Role("EMPLOYEE"));
		roles.add(new Role("CUSTOMER"));
		roles.add(new Role("USER"));

		roleService.save(roles);

		// Permissions definition
		List<Permission> permissions = new ArrayList<>();
		permissions.add(new Permission("ACCESS_REPORT"));
		permissions.add(new Permission("UPLOAD_PRODUCT"));
		permissions.add(new Permission("UPDATE_PRODUCT"));

		permissionService.save(permissions);


		// Administrative account creation
		List<Role> rolesAdmin = new ArrayList<>();
        rolesAdmin.add(new Role("ADMIN"));

        UserStatus status = UserStatus.ACTIVE;

        LocalDate accountCreatedDate = LocalDate.now();

//        LocalDate statusChangedDate = LocalDate.now();
//
//        Cart cart = new Cart();

//        User newAdmin = new User("admin@mail.com", "Admin", "Admin", "0123456789", accountCreatedDate, "admin", rolesAdmin, status, 0.0, statusChangedDate, cart);
        User newAdmin = new User("admin@mail.com", "Admin", "Admin", "0123456789", accountCreatedDate, "admin", rolesAdmin, status, 0.0);
        userService.createAdmin(newAdmin);

		initProductData();
    }

    void initProductData() {
        Product p1 = new Product("Samsung S10", "From korean", 1000.0, "aaa@email.com", "image");
        Product p2 = new Product("Huawei Mate40", "From China", 1032.0, "aaa@email.com", "image");
        Product p3 = new Product("iphone 10", "From USA", 1099.0, "aaa@email.com", "image");
        Product p4 = new Product("LG H10", "From korean", 899.0, "aaa@email.com", "image");
        Product p5 = new Product("OnePlus 8pro", "From China", 999.0, "aaa@email.com", "image");
        Product p6 = new Product("T Shirt", "From USA", 30.0, "bbb@email.com", "image");
        Product p7 = new Product("Pants", "From USA", 40.0, "bbb@email.com", "image");
        Product p8 = new Product("Rolex watch", "From Swiss", 20000.0, "ccc@email.com", "image");
        Product p9 = new Product("Bag", "From Swiss", 900.0, "ccc@email.com", "image");
        Product p10 = new Product("Glass", "From British", 400.0, "ccc@email.com", "image");
        productService.addProduct(p1);
        productService.addProduct(p2);
        productService.addProduct(p3);
        productService.addProduct(p4);
        productService.addProduct(p5);
        productService.addProduct(p6);
        productService.addProduct(p7);
        productService.addProduct(p8);
        productService.addProduct(p9);
        productService.addProduct(p10);

    }


}
