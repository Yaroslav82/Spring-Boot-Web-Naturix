package com.example.app.SpringBootWebNaturix.service;

import com.example.app.SpringBootWebNaturix.entity.Order;
import com.example.app.SpringBootWebNaturix.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.StreamSupport;

@Service
public class OrderService {

    @Autowired
    OrderRepository repository;

    private static final Logger LOGGER =
            Logger.getLogger(OrderService.class.getName());

    public List<Order> getAll() {
        Iterable<Order> iterable = repository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false).toList();
    }

    public void makeOrder(Order order) {
        repository.save(order);
    }

    public void changeStatus(Long id) {
        Optional<Order> optional = repository.findById(id);
        if (optional.isPresent()) {
            Order order = optional.get();
            order.setStatus("Delivered");
            repository.save(order);
            LOGGER.info("Order №" + id + " status changed to delivered");
        }
    }

    public void delete(Long id) {
        repository.deleteById(id);
        LOGGER.info("Order №" + id + " deleted");
    }
}
