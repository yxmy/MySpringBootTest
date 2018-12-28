package com.example.demoSpring4.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by admin on 2018/6/11.
 */
@Entity
@Setter
@Getter
public class Student {

    public Student(){
    }

    public Student(Long id, String name){
        this.id=id;
        this.name=name;
    }

    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
