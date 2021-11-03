package com.psc.sample.reactor1.service;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Food {

    private String description;
    private boolean delivered = false;

    public static Food status(Food food){
        Food newFood = new Food(food.description, true);
        return newFood;
    }
}
