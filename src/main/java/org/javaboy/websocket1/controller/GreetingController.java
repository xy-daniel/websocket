package org.javaboy.websocket1.controller;

import org.javaboy.websocket1.bean.Chat;
import org.javaboy.websocket1.bean.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.security.Principal;

@Controller
public class GreetingController {

    @Resource
    SimpMessagingTemplate simpMessagingTemplate;

//    /**
//     * 通过/hello接收消息后转发到/topic/greetings
//     * @param message  接收的消息
//     * @return 返回的消息
//     */
//    @MessageMapping("/hello")
//    @SendTo("/topic/greetings")
//    public Message greeting(Message message){
//        return message;
//    }

    /**
     * 群发的第二种学法
     *
     * @param message 接收到的消息
     */
    @MessageMapping("/hello")
    public void greeting(Message message) {
        simpMessagingTemplate.convertAndSend("/topic/greetings", message);
    }

    /**
     * websocket的点对点发送
     *
     * @param principal 保存有登录的用户的信息
     * @param chat      接收的待处理的消息
     */
    @MessageMapping("/chat")
    public void chat(Principal principal, Chat chat) {
        chat.setFrom(principal.getName());
        simpMessagingTemplate.convertAndSendToUser(chat.getTo(), "/queue/chat", chat);
    }

}
