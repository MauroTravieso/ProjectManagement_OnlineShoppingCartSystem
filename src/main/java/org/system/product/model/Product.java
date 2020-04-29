package org.system.product.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class Product {

    @Id
    @NotEmpty
    @Column(unique = true)
    private int id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    @NotEmpty
    private double price;

    @NotEmpty
    private String product_status;

    @NotEmpty
    private int vendor_id;

    @NotEmpty
    private String image;

}
