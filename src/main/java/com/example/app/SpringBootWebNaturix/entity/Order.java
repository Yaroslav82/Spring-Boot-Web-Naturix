package com.example.app.SpringBootWebNaturix.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    public Order(String email, String address, String orderText, String status) {
        this.email = email;
        this.address = address;
        this.orderText = orderText;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "email")
    String email;
    @Column(name = "address")
    String address;
    @Column(name = "order_text")
    String orderText;
    @Column(name = "status")
    String status;
}
