package com.example.app.SpringBootWebNaturix.repository;

import com.example.app.SpringBootWebNaturix.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
