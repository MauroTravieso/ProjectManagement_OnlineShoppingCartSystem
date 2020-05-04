package org.system.payment.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;
import org.system.admin.model.User;
import org.system.shoppingcart.model.Line;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Valid
    private Address shippingAddress;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Address billingAddress;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Valid
    private Payment payment;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Line> lines;

    private int status = 1;

    private LocalDateTime localDateTime;

    public Double getTotal() {
        Double total = 0.0;
        for (Line line : lines) {
            total += line.getPrice();
        }
        return total;
    }

    public String getStatus() {
        switch (this.status) {
            case 1:
                return "pending";
            case 2:
                return "on way";
            case 3:
                return "delivred";
            case 4:
                return "canceled";
            default:
                return "undefined";
        }
    }
}
