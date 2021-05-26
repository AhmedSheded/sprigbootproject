package com.ahmedsheded.pos.demo8.repository;

import com.ahmedsheded.pos.demo8.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {
    ProductEntity findByBarcode(String barcode);
}
