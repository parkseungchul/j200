package com.psc.sample.reactor2.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    private String id;
    private String name;
    private String description;
    private double price;

    public Item(String name, String description, double price){
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
