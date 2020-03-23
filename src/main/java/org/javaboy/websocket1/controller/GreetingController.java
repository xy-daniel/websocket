package org.javaboy.websocket1.controller;

import org.javaboy.websocket1.bean.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    /**
     * 通过/hello接收消息后转发到/topic/greetings
     * @param message  接收的消息
     * @return 返回的消息
     */
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message greeting(Message message){
        return message;
    }

}
