package com.yx.springboot.demoSpring.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2018/4/17.
 */
@Component
@ConfigurationProperties(prefix = "author")
@Getter
@Setter
public class Author {

    private String name;

    private int age;

}
