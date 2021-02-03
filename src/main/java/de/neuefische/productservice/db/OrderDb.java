package de.neuefische.productservice.db;

import de.neuefische.productservice.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDb {

    private ArrayList<Order> orderList;

    public OrderDb() {
        orderList = new ArrayList<Order>();
    }

    public Order addOrder(Order order) {
        this.orderList.add(order);
        return order;
    }

    public List<Order> listOrders() {
        return this.orderList;
    }
}
