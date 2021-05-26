package com.ahmedsheded.pos.demo8.repository;

import com.ahmedsheded.pos.demo8.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<OrderEntity, Integer> {
}
