package com.example.demoSpring3.controller;

import com.example.demoSpring3.bean.WiselyMessage;
import com.example.demoSpring3.bean.WiselyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * Created by admin on 2018/6/4.
 */
@Controller
public class WsController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new WiselyResponse("Welcome!," + message.getName() + "!");
    }

    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg){
        if(principal.getName().equals("wyf")){
            simpMessagingTemplate.convertAndSendToUser("qwe", "/queue/notifications",
                    principal.getName() + "-send:" + msg);
        }else{
            simpMessagingTemplate.convertAndSendToUser("wyf", "/queue/notifications",
                    principal.getName() + "-send:" + msg);
        }
    }
}
