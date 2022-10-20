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
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String address;
    @NonNull
    private String postCode;
    @NonNull
    private String country;
    @NonNull
    private String phoneNumber;

    public Address(@NonNull String address, @NonNull String postCode, @NonNull String country, @NonNull String phoneNumber) {
        this.address = address;
        this.postCode = postCode;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + this.id + ", name='" + this.address + '\'' + ", postCode='" + this.postCode + '\'' + ", country='" + this.country + ", phoneNumber='" + this.phoneNumber + '}';
    }
}
