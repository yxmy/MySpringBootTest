package com.example.demoSpring4.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by admin on 2018/6/11.
 */
@Entity
@Getter
@Setter
@NamedQuery(name="Person.withNameAndAddressNamedQuery",
query = "select p from Person p where p.name = ?1 and p.address = ?2")
public class Person {

    public Person(){
    }

    public Person(Long id, String name, Integer age, String address){
        this.id=id;
        this.name=name;
        this.age=age;
        this.address=address;
    }

    @Id
    @GeneratedValue
    private Long id;

    private Integer age;

    private String name;

    private String address;
}
