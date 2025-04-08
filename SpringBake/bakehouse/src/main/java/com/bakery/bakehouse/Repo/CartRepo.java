package com.bakery.bakehouse.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bakery.bakehouse.Entity.Cart;

public interface CartRepo extends JpaRepository<Cart,Integer>{
	Cart findBycartId(Integer cartId);
	// Find all cart items for a given customer ID
	List<Cart> findByCustomer_CustId(Integer custId); 

}
