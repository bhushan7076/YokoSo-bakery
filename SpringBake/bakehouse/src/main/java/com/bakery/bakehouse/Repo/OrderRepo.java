package com.bakery.bakehouse.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bakery.bakehouse.Entity.Order;

public interface OrderRepo extends JpaRepository<Order,Integer> {
		Order findByorderId(Integer orderId);
}
