package com.yx.springboot.demoSpring.service;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by admin on 2018/4/18.
 */
@Getter
@Setter
public class HelloService {

    private String msg;

    public String say(){
        return "hello" + msg;
    }
}
