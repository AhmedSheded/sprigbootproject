package com.ahmedsheded.pos.demo8.repository;

import com.ahmedsheded.pos.demo8.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleRepo extends JpaRepository<SaleEntity, Integer> {
    List<SaleEntity> findAllByOrderId(Integer orderId);
}
