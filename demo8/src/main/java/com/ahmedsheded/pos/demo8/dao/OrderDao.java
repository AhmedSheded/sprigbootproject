package com.ahmedsheded.pos.demo8.dao;

import com.ahmedsheded.pos.demo8.dto.OrderDto;
import com.ahmedsheded.pos.demo8.entity.OrderEntity;
import com.ahmedsheded.pos.demo8.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDao {
    @Autowired
    private OrderRepo orderRepo;

    public OrderEntity saveOrder(List<OrderDto> orderDtos){
        double total = 0.0;

        for (OrderDto o : orderDtos){
            total += o.getProductPrice();
        }
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setTotal(total);
        return this.orderRepo.save(orderEntity);
    }

    public List<OrderEntity> getAllOrder(){
        return this.orderRepo.findAll();
    }
}
