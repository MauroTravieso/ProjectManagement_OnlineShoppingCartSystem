package org.system.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Task.class)
public abstract class Task_ {

	public static volatile SingularAttribute<Task, String> date;
	public static volatile SingularAttribute<Task, String> description;
	public static volatile SingularAttribute<Task, String> startTime;
	public static volatile SingularAttribute<Task, String> stopTime;
	public static volatile SingularAttribute<Task, Long> id;
	public static volatile SingularAttribute<Task, User> user;

	public static final String DATE = "date";
	public static final String DESCRIPTION = "description";
	public static final String START_TIME = "startTime";
	public static final String STOP_TIME = "stopTime";
	public static final String ID = "id";
	public static final String USER = "user";

}

