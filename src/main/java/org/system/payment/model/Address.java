package org.system.payment.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
}
