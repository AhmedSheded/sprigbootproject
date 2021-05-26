package com.ahmedsheded.pos.demo8.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Table(name = "orders")
@Data
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "total")
    private double total;

//    @JsonBackReference
//    @OneToOne(mappedBy = "order")
//    @JoinColumn(name = "order_id", insertable = false, updatable = false)
//    private SaleEntity sale;
}
