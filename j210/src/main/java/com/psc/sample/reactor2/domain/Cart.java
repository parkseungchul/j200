package com.psc.sample.reactor2.domain;

import com.psc.sample.reactor2.domain.vo.CartItem;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    @Id
    private String id;
    private List<CartItem> cartItems;

    public Cart(String id){
        this(id, new ArrayList<CartItem>());
    }

    public void removeItem(CartItem cartItem){
        this.cartItems.remove(cartItem);
    }

}
