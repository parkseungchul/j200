package com.psc.sample.sender.component;

import com.psc.sample.sender.dto.Dept;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverModule {

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(name = "dept", type = ExchangeTypes.TOPIC),
            value = @Queue(name= "dept-fourth"),  // 새거
            key = "dept-third") // 받는거
    )
    public void receive2(Dept dept){
        System.out.println("4 >> 받았음: " + dept.toString());
    }
}
