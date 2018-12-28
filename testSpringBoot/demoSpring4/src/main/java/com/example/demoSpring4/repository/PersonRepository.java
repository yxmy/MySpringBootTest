package com.example.demoSpring4.repository;

import com.example.demoSpring4.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by admin on 2018/6/11.
 */
public interface PersonRepository extends CustomRepository<Person, Long>{

    List<Person> findByAddress(String address);

    Person findByNameAndAddress(String name, String address);

    @Query("select p from Person p where p.name = :name and p.address = :address")
    Person query1(@Param("name")String name, @Param("address") String address);

    Person withNameAndAddressNamedQuery(String name, String address);
}
