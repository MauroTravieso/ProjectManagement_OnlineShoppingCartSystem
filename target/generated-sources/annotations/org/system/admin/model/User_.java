package org.system.admin.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.system.role.model.Role;
import org.system.task.model.Task;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> lastName;
	public static volatile SingularAttribute<User, LocalDate> accountCreatedDate;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> phoneNumber;
	public static volatile SingularAttribute<User, LocalDate> statusChangedDate;
	public static volatile SingularAttribute<User, Double> quota;
	public static volatile ListAttribute<User, Role> roles;
	public static volatile SingularAttribute<User, String> name;
	public static volatile SingularAttribute<User, String> email;
	public static volatile ListAttribute<User, Task> tasks;
	public static volatile SingularAttribute<User, UserStatus> status;

	public static final String LAST_NAME = "lastName";
	public static final String ACCOUNT_CREATED_DATE = "accountCreatedDate";
	public static final String PASSWORD = "password";
	public static final String PHONE_NUMBER = "phoneNumber";
	public static final String STATUS_CHANGED_DATE = "statusChangedDate";
	public static final String QUOTA = "quota";
	public static final String ROLES = "roles";
	public static final String NAME = "name";
	public static final String EMAIL = "email";
	public static final String TASKS = "tasks";
	public static final String STATUS = "status";

}

