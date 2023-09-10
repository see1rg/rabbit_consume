package com.esee1rg.rabbitappconsume.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MQConfig {
    public static final String QUEUE1 = "my-queue-1";
    public static final String QUEUE2 = "my-queue-2";
    public static final String QUEUE3 = "my-queue-3";
    public static final String EXCHANGE = "message_exchange";

    @Bean
    public Queue queue1() {
        return new Queue(QUEUE1);
    }

    @Bean
    public Queue queue2() {
        return new Queue(QUEUE2);
    }

    @Bean
    public Queue queue3() {
        return new Queue(QUEUE3);
    }

    @Bean
    public FanoutExchange exchange() {
        return new FanoutExchange(EXCHANGE);
    }

    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(queue1()).to(exchange());
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(queue2()).to(exchange());
    }

    @Bean
    public Binding binding3() {
        return BindingBuilder.bind(queue3()).to(exchange());
    }
}
