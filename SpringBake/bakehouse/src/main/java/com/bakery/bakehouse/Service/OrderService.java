package com.bakery.bakehouse.Service;
import com.bakery.bakehouse.Entity.Cart;
import com.bakery.bakehouse.Entity.Order;
import com.bakery.bakehouse.Repo.CartRepo;
import com.bakery.bakehouse.Repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
	 @Autowired
	    private CartRepo cartRepository;

	    @Autowired
	    private OrderRepo orderRepository;

	    public void placeOrder(Integer custId) {
	        List<Cart> cartItems = cartRepository.findByCustomer_CustId(custId);

	        if (cartItems.isEmpty()) {
	            throw new RuntimeException("Cart is empty! Cannot place order.");
	        }

	        for (Cart cart : cartItems) {
	            Order order = new Order(
	                cart.getCustomer(),
	                cart.getProduct(),
	                cart.getCartQuantity(),
	                cart.getCartPrice(),
	                cart.getCartTotal()
	            );
	            orderRepository.save(order);
	        }

	        cartRepository.deleteAll(cartItems); // Remove cart items after order placement
	    }
	    
	    public List<Order> getOrdersByCustomerId(Integer custId) {
	        return orderRepository.findByCustomer_CustId(custId);
	    }
}
