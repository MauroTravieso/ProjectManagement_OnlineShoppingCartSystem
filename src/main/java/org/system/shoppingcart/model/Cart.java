package org.system.shoppingcart.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Cart Model
 *
 * Bugs: none known
 *
 * @author       Shiraz Shrestha (987052) - Team II APR2020
 * @version      1.0
 *
 */

@Entity
@Data
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Line> lines;

    public void addLine(Line line) {
        if (lines == null)
            lines = new ArrayList<>();
        lines.add(line);
    }

    public Double getTotal() {
        Double total = 0.0;
        for (Line line : lines) {
            total += line.getPrice();
        }
        return total;
    }
}
