package org.system.shoppingcart;

import org.system.shoppingcart.model.Cart;
import org.system.shoppingcart.model.Line;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cart.class)
public abstract class Cart_ {

	public static volatile SingularAttribute<Cart, Long> id;
	public static volatile ListAttribute<Cart, Line> lines;

	public static final String ID = "id";
	public static final String LINES = "lines";

}

