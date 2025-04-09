package com.bakery.bakehouse.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bakery.bakehouse.Entity.Order;

public interface OrderRepo extends JpaRepository<Order,Integer> {
	List<Order> findByCustomer_CustId(Integer custId);


}
