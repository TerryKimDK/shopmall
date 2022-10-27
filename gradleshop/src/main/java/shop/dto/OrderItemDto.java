package shop.dto;


import lombok.Getter;
import lombok.Setter;
import shop.entity.OrderItem;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class OrderItemDto {

    private String itemName;
    private int count;
    private int orderPrice;
    private String imgUrl;

    public OrderItemDto(OrderItem orderItem, String imgUrl) {
        this.itemName = orderItem.getItem().getItemName();
        this.count = orderItem.getCount();
        this.orderPrice = orderItem.getOrderPrice();
        this.imgUrl = imgUrl;
    }
}