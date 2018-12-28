package com.example.demoSpring3.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by admin on 2018/6/4.
 */
@Getter
@Setter
public class WiselyResponse {

    private String responseMessage;

    public WiselyResponse(){
    }

    public WiselyResponse(String responseMessage){
        this.responseMessage = responseMessage;
    }
}
