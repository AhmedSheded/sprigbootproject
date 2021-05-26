package com.abdabughazaleh.pos.pos.controller;

import com.abdabughazaleh.pos.pos.dao.ProductDao;
import com.abdabughazaleh.pos.pos.entity.ProductEntity;
import javax.print.attribute.standard.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/products")
@RestController
@CrossOrigin
public class ProductController {

  @Autowired
  private ProductDao productDao;


  @PostMapping(value = "/add-product", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE} )
  @ResponseBody
  public ProductEntity addProduct(@RequestBody ProductEntity product) {
    return this.productDao.addProduct(product);
  }

  @PostMapping("/update-product")
  public ProductEntity updateProduct(@RequestBody ProductEntity product) {
    return this.productDao.updateProduct(product);
  }

  @GetMapping("/delete-product")
  public String deleteProduct(@RequestParam Integer productId) {
    this.productDao.deleteProduct(productId);
    return "success";
  }

  @GetMapping("/get-by-barcode")
  public ProductEntity getProductByBarcode(@RequestParam String barcode) {
    return this.productDao.getProductByBarcode(barcode);
  }

  @GetMapping("/get-by-id")
  public ProductEntity getProductById(@RequestParam Integer productId) {
    return this.productDao.getProductById(productId);
  }

  @GetMapping("/get-all-products")
  public List<ProductEntity> getAllProducts() {
    return this.productDao.getAllProducts();
  }


}
