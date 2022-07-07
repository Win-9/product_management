package jpabook.jpashop.controller;


import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
public class MemberForm {

    private String name;
    private String city;
    private String street;
    private String zipcode;

}
