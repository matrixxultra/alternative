package com.alternative.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alternative.entities.Order;
import com.alternative.entities.OrderItem;



@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {


}
