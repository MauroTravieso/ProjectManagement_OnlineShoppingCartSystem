package org.system.payment.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Payment Model
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
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    @Size(min=16,max=16, message = "{Size.cardNumber}")
    private String cardNumber;

    @Override
    public String toString(){
        return name;
    }

}
