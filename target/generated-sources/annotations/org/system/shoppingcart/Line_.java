package org.system.shoppingcart;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.system.product.model.Product;
import org.system.shoppingcart.model.Line;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Line.class)
public abstract class Line_ {

	public static volatile SingularAttribute<Line, Product> product;
	public static volatile SingularAttribute<Line, Integer> quantity;
	public static volatile SingularAttribute<Line, Long> id;

	public static final String PRODUCT = "product";
	public static final String QUANTITY = "quantity";
	public static final String ID = "id";

}

