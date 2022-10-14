package shop.domain;


import javax.persistence.*;
import java.util.List;

public class Item {

    @ManyToMany
    @JoinTable(
            name = "order_item",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Member> member;
}