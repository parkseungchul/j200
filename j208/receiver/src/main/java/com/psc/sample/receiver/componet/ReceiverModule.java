package com.psc.sample.receiver.componet;

import com.psc.sample.receiver.dto.Dept;
import lombok.Setter;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class ReceiverModule {

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(name = "time", type = ExchangeTypes.TOPIC),
            value = @Queue(name= "time-second"),
            key = "time-first")
    )
    public void receive(String msg){
        System.out.println(msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(name = "dept", type = ExchangeTypes.TOPIC),
            value = @Queue(name= "dept-second"),  // 새거
            key = "dept-first") // 받는거
    )
    @SendTo("dept/dept-third")
    public Dept receive2(Dept dept){
        System.out.println("2 >> 받았음: " + dept.toString());

        Dept dept1 = new Dept(20, "third-dName", "third-loc", "");
        System.out.println("3 << 보냈음: " + dept1.toString());
        return dept1;
    }
}
