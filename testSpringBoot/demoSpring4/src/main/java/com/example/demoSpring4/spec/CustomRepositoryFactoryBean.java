package com.example.demoSpring4.spec;

import com.example.demoSpring4.repository.impl.CustomRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by admin on 2018/6/11.
 */
public class CustomRepositoryFactoryBean<T extends JpaRepository<S, ID>, S, ID extends Serializable>
                                extends JpaRepositoryFactoryBean<T, S, ID>{

    public CustomRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
        super(repositoryInterface);
    }

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager){
        return new CustomRepositoryFactory(entityManager);
    }

    private static class CustomRepositoryFactory extends JpaRepositoryFactory{
        public CustomRepositoryFactory(EntityManager entityManager){
            super(entityManager);
        }

        protected <T, ID extends Serializable>SimpleJpaRepository<?, ?> getTargetRepository(
                RepositoryInformation repositoryInformation, EntityManager entityManager
        ){
            return new CustomRepositoryImpl<T, ID>((Class<T>)repositoryInformation.getDomainType(), entityManager);
        }
    }

    protected Class<?> getRepositoryBaseClass(RepositoryMetadata repositoryMetadata){
        return CustomRepositoryImpl.class;
    }
}
