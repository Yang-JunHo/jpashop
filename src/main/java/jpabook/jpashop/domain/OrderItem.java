package jpabook.jpashop.domain;

import jakarta.persistence.Entity;
import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class OrderItem {

    private Long id;

    private Item item;

    private Order order;

    private int orderPrice; //주문 가격
    private int count; // 주문 수량
}
