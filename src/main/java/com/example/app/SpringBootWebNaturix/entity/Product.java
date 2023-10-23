package com.example.app.SpringBootWebNaturix.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "img")
    String img;
    @Column(name = "name")
    String name;
    @Column(name = "type")
    String type;
    @Column(name = "price")
    Double price;
}
