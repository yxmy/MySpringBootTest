package com.example.demoSpring4.spec;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/6/11.
 */
public class CustomerSpec {

    public static <T> Specification<T> byAuto(final EntityManager entityManager, final T example){
        final Class<T> type = (Class<T>) example.getClass();
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                EntityType<T> entity = entityManager.getMetamodel().entity(type);

                for(Attribute<T, ?> attribute : entity.getDeclaredAttributes()){
                    Object attrValue = getValue(example, attribute);
                    if(attrValue != null){
                        if(attribute.getJavaType() == String.class){
                            if(!StringUtils.isEmpty(attrValue)){
                                predicates.add(criteriaBuilder.like(root.get(attribute(entity, attribute.getName(), String.class)), pattern((String) attrValue)));
                            }
                        }else{
                            predicates.add(criteriaBuilder.equal(root.get(attribute(entity, attribute.getName(), attribute.getClass())), attrValue));
                        }
                    }
                }
                Predicate [] arr = new Predicate[predicates.size()];
                return predicates.isEmpty() ? criteriaBuilder.conjunction() : criteriaBuilder.and(predicates.toArray(arr));
            }

            private <T> Object getValue(T example, Attribute<T, ?> attribute){
                return ReflectionUtils.getField((Field) attribute.getJavaMember(), example);
            }

            private <E, T> SingularAttribute<E, T> attribute(EntityType<E> entityType, String fieleName, Class<T> fieldClass){
                return entityType.getDeclaredSingularAttribute(fieleName, fieldClass);
            }
        };
    }

    static private String pattern(String string){
        return "%"+string+"%";
    }

}
