package com.bakoish.restaurantRESTful.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;
    private String surname;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;

    public Customer(@NonNull String name, String surname, Address address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }
}
