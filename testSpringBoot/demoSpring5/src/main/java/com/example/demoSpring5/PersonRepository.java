package com.example.demoSpring5;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by admin on 2018/7/23.
 */
@RepositoryRestResource(path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    @RestResource(path = "nameStartsWith", rel = "nameStartsWith")
    Person findByNameStartsWith(@Param("name") String name);
}


