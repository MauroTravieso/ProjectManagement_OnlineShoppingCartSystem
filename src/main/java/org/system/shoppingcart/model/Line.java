package org.system.shoppingcart.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.system.product.model.Product;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Line {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

    public Double getPrice(){
        return quantity * product.getPrice();
    }
}
