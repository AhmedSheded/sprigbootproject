package com.ahmedsheded.pos.demo8.dao;

import com.ahmedsheded.pos.demo8.dto.OrderDto;
import com.ahmedsheded.pos.demo8.entity.OrderEntity;
import com.ahmedsheded.pos.demo8.entity.SaleEntity;
import com.ahmedsheded.pos.demo8.repository.SaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleDao {
    @Autowired
    private SaleRepo saleRepo;

    private OrderDao orderDao;

    public SaleDao(OrderDao orderDao){
        this.orderDao = orderDao;
    }

    public OrderEntity saveSale(List<OrderDto> orders){
        if (orders.size() == 0)
            return null;
        OrderEntity ord = this.orderDao.saveOrder(orders);
        orders.forEach(o -> {
            SaleEntity sale = new SaleEntity();
            sale.setOrderId(ord.getOrderId());
            sale.setProductId(o.getProductId());
            this.saleRepo.save(sale);
        });
        return ord;
    }

    public List<SaleEntity> getSales(){
        return this.saleRepo.findAll();
    }

    public List<SaleEntity> getSaleByOrderId(Integer orderId){
         return this.saleRepo.findAllByOrderId(orderId);
    }
}
