package com.yx.springboot.demoSpring.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by admin on 2018/4/18.
 */
@ConfigurationProperties(prefix = "hello")
@Getter
@Setter
public class HelloServiceProperties {

    public static final String MSG = "world";

    private String msg;
}
