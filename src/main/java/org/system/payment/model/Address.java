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
 * Address Model
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
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String street;

    @Size(min = 2,max=2, message = "{Size.state}")
    private String state;

    @Size(min=5,max = 5,message = "{Size.zipCode}")
    private String zipCode;

    @NotBlank
    private String name;

    @Override
    public String toString(){
        return street + ", " + state + ", " + zipCode;
    }
}
