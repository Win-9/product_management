package jpabook.jpashop.domain;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Embeddable
public class Address {
    private String city;
    private String street;
    private String zipcode;
}