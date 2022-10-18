package com.bakoish.restaurantRESTful.model;

import com.sun.xml.bind.v2.TODO;
import lombok.*;

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

    @Override
    public String toString() {
        return "Customer{" + "id=" + this.id + ", name='" + this.name + '\'' + ", surname='" + this.surname + '\'' + ", Adresss='" + this.address + '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
