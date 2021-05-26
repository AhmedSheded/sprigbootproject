package com.ahmedsheded.pos.demo8.controller;

import com.ahmedsheded.pos.demo8.dao.ProductDao;
import com.ahmedsheded.pos.demo8.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/products")
@RestController
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductDao productDao;

    @PostMapping(path = "/add-product")
    public ProductEntity addProduct(@RequestBody ProductEntity product){
        return this.productDao.addProduct(product);
    }

    @PostMapping(path = "/update-product")
    public ProductEntity updateProduct(@RequestBody ProductEntity product){
        return this.productDao.updateProduct(product);
    }

    @GetMapping(path = "/delete-product")
    public String deleteProduct(@RequestParam Integer productId){
        this.productDao.deleteProduct(productId);
        return "user deleted";
    }

    @GetMapping(path = "/get-by-barcode")
    public ProductEntity getProductByBarcode(@RequestParam String barcode){
        return this.productDao.getProductByBarcode(barcode);
    }

    @GetMapping(path = "/findById")
     public ProductEntity getProductById(@RequestParam Integer productId){
        return this.productDao.getProductById(productId);
    }

    @GetMapping(path = "/getAllProducts")
    public List<ProductEntity> getAllProducts(){
        return this.productDao.getAllProducts();
    }

}
