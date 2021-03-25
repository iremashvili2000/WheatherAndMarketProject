package com.example.demo.repository;

import com.example.demo.models.realmodel.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
    Order findByEmail(String email);
    void deleteByEmail(String email);
}
