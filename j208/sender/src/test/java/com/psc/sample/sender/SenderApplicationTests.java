package com.psc.sample.sender;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class SenderApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void rabbitTest(){
        LocalDateTime nowDateTime = LocalDateTime.now();
        String time = nowDateTime.toString();
        System.out.println(time.toString());
        rabbitTemplate.convertAndSend("hello", "===>" + time);
    }

}
