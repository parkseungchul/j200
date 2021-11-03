package com.psc.sample.reactor2;

import com.psc.sample.reactor2.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.MongoOperations;

@SpringBootApplication
public class Reactor2Application {

    public static void main(String[] args) {
        SpringApplication.run(Reactor2Application.class, args);
    }

    @Autowired
    MongoOperations mongoOperations;

    @EventListener(ApplicationReadyEvent.class)
    public void doSomething(){
        Item item1 = new Item("lego", "made in usa", 20.00);
        Item item2 = new Item("lego", "made in china", 10.00);
        Item item3 = new Item("rc car", "made in usa", 40.00);
        Item item4 = new Item("rc car", "made in china", 20.00);
        Item item5 = new Item("rc car", "made in india", 15.00);
        Item item6 = new Item("drone", "made in korea", 100.00);
        mongoOperations.save(item1);
        mongoOperations.save(item2);
        mongoOperations.save(item3);
        mongoOperations.save(item4);
        mongoOperations.save(item5);
        mongoOperations.save(item6);
    }

}
