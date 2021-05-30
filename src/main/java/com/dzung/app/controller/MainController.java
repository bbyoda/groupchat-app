package com.dzung.app.controller;

import com.dzung.app.Model.Chat;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

    @MessageMapping("chat.sendMessage")
    @SendTo("/topic/public")
    public Chat sendMessage(Chat chat) {
        return chat;
    }

    @MessageMapping("chat.addUser")
    @SendTo("/topic/public")
    public Chat addUser(Chat chat, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chat.getSender());
        return chat;
    }
}
