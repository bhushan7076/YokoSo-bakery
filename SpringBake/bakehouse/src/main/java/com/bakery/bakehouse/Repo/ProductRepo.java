package com.bakery.bakehouse.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bakery.bakehouse.Entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

		Product findBypName( String pName);
}