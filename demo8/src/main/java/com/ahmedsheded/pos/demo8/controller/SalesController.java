package com.ahmedsheded.pos.demo8.controller;

import com.ahmedsheded.pos.demo8.dao.SaleDao;
import com.ahmedsheded.pos.demo8.entity.SaleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/sales")
@RestController
@CrossOrigin
public class SalesController {
    @Autowired
    private SaleDao saleDao;

    @GetMapping(path = "/getSales")
     public List<SaleEntity> getSales(){
        return this.saleDao.getSales();
    }

    @GetMapping(path = "/findByOrderId")
      public List<SaleEntity> getSaleByOrderId(@RequestParam Integer orderId){
         return this.saleDao.getSaleByOrderId(orderId);
    }
}
