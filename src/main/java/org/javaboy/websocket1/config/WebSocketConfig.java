package org.javaboy.websocket1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * websocket配置类
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * 配置消息代理
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //消息代理的前缀
        registry.enableSimpleBroker("/topic", "/queue");
        //以/app开始的请求交给代理进行处理
        registry.setApplicationDestinationPrefixes("/app");
    }

    /**
     * 注册连接点
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat").withSockJS();
    }
}
