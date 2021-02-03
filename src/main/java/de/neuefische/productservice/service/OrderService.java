package de.neuefische.productservice.service;

import de.neuefische.productservice.db.OrderDb;
import de.neuefische.productservice.db.ProductDb;
import de.neuefische.productservice.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private OrderDb orderDb;
    private ProductDb productDb;

    @Autowired
    public OrderService(OrderDb orderDb, ProductDb productDb) {
        this.orderDb = orderDb;
        this.productDb = productDb;
    }

    public List<Order> listOrders() {
        return orderDb.listOrders();
    }

    public Order addOrder(Order order){
        for (String orderedProduct : order.getOrderedProducts()) {
            if(!productDb.productExists(orderedProduct)){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
        }

        return orderDb.addOrder(order);
    }

}
