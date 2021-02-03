package de.neuefische.productservice.controller;

import de.neuefische.productservice.model.Order;
import de.neuefische.productservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {

    public final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PutMapping("add")
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @GetMapping("list")
    public List<Order> listOrders(){
        return orderService.listOrders();
    }

}
