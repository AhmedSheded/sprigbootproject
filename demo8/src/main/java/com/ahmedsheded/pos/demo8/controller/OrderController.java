package com.ahmedsheded.pos.demo8.controller;

import com.ahmedsheded.pos.demo8.dao.OrderDao;
import com.ahmedsheded.pos.demo8.dao.SaleDao;
import com.ahmedsheded.pos.demo8.dto.OrderDto;
import com.ahmedsheded.pos.demo8.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/orders")
@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private SaleDao saleDao;

    @PostMapping(path = "/saveOrder")
    public OrderEntity saveOrder(@RequestBody List<OrderDto> orderDtos){
        return this.saleDao.saveSale(orderDtos);
    }

    @GetMapping(path = "getAll")
    public List<OrderEntity> getAllOrders(){
        return this.orderDao.getAllOrder();
    }

}
