package org.system.product.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Product {

    @Id
    @NotNull
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty(message = "Please enter title")
    private String title;

    @NotEmpty(message = "Please enter description")
    private String description;

    @NotNull(message = "Please enter price")
    private double price;

    private ProductStatus product_status = ProductStatus.AVAILABLE;

    private ProductProcessStatus product_process_status = ProductProcessStatus.PENDING;

    @NotEmpty
    private String vendor_id;

    @NotEmpty
    private String image;

    public Product() {

    }

    public Product(String title, String description, double price, String vendor_id, String image) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.vendor_id = vendor_id;
        this.image = image;
    }

}
