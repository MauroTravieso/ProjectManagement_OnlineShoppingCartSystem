package org.system.product.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class Product_ {

	public static volatile SingularAttribute<Product, String> image;
	public static volatile SingularAttribute<Product, Double> price;
	public static volatile SingularAttribute<Product, Integer> vendor_id;
	public static volatile SingularAttribute<Product, String> description;
	public static volatile SingularAttribute<Product, String> product_status;
	public static volatile SingularAttribute<Product, Integer> id;
	public static volatile SingularAttribute<Product, String> title;

	public static final String IMAGE = "image";
	public static final String PRICE = "price";
	public static final String VENDOR_ID = "vendor_id";
	public static final String DESCRIPTION = "description";
	public static final String PRODUCT_STATUS = "product_status";
	public static final String ID = "id";
	public static final String TITLE = "title";

}

