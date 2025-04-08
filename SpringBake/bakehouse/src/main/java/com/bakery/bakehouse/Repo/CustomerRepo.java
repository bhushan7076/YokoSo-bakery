package com.bakery.bakehouse.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bakery.bakehouse.Entity.Customer;


@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
	
	Customer findByCustId(Integer custId);

	 Customer findByCustEmail(String custEmail); // Find customer by email

	    Customer findByCustUsername(String custUsername); // 
}
