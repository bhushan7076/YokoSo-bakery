package com.bakery.bakehouse.Controller;

import com.bakery.bakehouse.Entity.Cart;
import com.bakery.bakehouse.Repo.CartRepo;
import com.bakery.bakehouse.dto.CartResponseDTO;
import com.bakery.bakehouse.dto.CustomerRequestDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartRepo cartRepo;

    @PostMapping("/customer")
    public ResponseEntity<List<CartResponseDTO>> getCartByCustomer(@RequestBody CustomerRequestDTO customerRequest) {
        Integer custId = customerRequest.getCustId(); // Extract custId from JSON

        List<Cart> cartItems = cartRepo.findByCustomer_CustId(custId);

        if (cartItems.isEmpty()) {
            return ResponseEntity.notFound().build();  // 404 if no items found
        }

        // Convert Cart entity to CartResponseDTO (only required fields)
        List<CartResponseDTO> response = cartItems.stream()
            .map(cart -> new CartResponseDTO(
                cart.getProduct().getPName(),  // Product Name
                cart.getCartQuantity(),        // Cart Quantity
                cart.getCartPrice(),           // Cart Price
                cart.getCartTotal()            // Cart Total
            ))
            .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

}
