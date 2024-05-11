package com.sample.order.controller;

import com.sample.order.model.OrderRequest;
import com.sample.order.service.CreateOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    CreateOrderService createOrderService;

    @PostMapping(path = "/order")
    public void createOrder(@RequestBody OrderRequest request) {
        createOrderService.createOrder(request);
    }
}
