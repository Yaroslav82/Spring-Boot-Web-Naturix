package com.example.app.SpringBootWebNaturix.repository;

import com.example.app.SpringBootWebNaturix.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
