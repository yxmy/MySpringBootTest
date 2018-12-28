package com.example.demoSpring4.repository.impl;

import com.example.demoSpring4.repository.CustomRepository;
import com.example.demoSpring4.spec.CustomerSpec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by admin on 2018/6/11.
 */
public class CustomRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements CustomRepository<T, ID>{

    private final EntityManager entityManager;

    public CustomRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Page<T> query(T example, Pageable pageable) {
        return findAll(CustomerSpec.byAuto(entityManager, example), pageable);
    }
}
