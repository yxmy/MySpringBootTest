package com.example.demoSpring4.controller;

import com.example.demoSpring4.model.Person;
import com.example.demoSpring4.model.Student;
import com.example.demoSpring4.repository.PersonRepository;
import com.example.demoSpring4.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by admin on 2018/6/11.
 */
@RestController
public class DataController {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public Person save(String name, String address, Integer age){
        Person p = this.personRepository.save(new Person(null, name, age, address));
        return p;
    }

    @RequestMapping(value = "/saveStu", method = RequestMethod.GET)
    public Student saveStu(String name, String address, Integer age){
        Student p = this.studentRepository.save(new Student(null, name));
        return p;
    }

    @RequestMapping(value = "q1", method = RequestMethod.GET)
    public List<Person> q1(String address){
        List<Person> list = this.personRepository.findByAddress(address);
        return list;
    }

    @RequestMapping("/q2")
    public Person q2(String name, String address){
        Person p = this.personRepository.findByNameAndAddress(name, address);
        return p;
    }

    @RequestMapping("/q3")
    public Person q3(String name, String address){
        Person p = this.personRepository.query1(name, address);
        return p;
    }

    @RequestMapping("/q4")
    public Person q4(String name, String address){
        Person p = this.personRepository.withNameAndAddressNamedQuery(name, address);
        return p;
    }

    @RequestMapping("/sort")
    public List<Person> sort(){
        List<Person> list = this.personRepository.findAll(new Sort(Sort.Direction.DESC, "age"));
        return list;
    }

    @RequestMapping("/page")
    public Page<Person> page(){
        Page<Person> list = this.personRepository.findAll(new PageRequest(0, 6));
        return list;
    }

    @RequestMapping("/auto")
    public Page<Person> auto(Person person){
        Page<Person> people = personRepository.query(person, new PageRequest(0, 5));
        return people;
    }
}
