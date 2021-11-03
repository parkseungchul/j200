package com.psc.sample.reactor2.domain.vo;

import com.psc.sample.reactor2.domain.Item;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {

    private Item item;
    private int quantity;

    public CartItem(Item item){
        this.item = item;
        this.quantity = 1;
    }

    public void increment(){
        this.quantity = this.quantity + 1;
    }

    public void decrement(){
        this.quantity = this.quantity - 1;
    }

    public boolean isOne(){
        if(this.quantity == 1){
            return true;
        }else{
            return false;
        }
    }
}
