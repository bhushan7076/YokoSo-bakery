package com.bakery.bakehouse.Controller;

import com.bakery.bakehouse.Entity.Cart;
import com.bakery.bakehouse.Repo.CartRepo;
import com.bakery.bakehouse.Service.OrderService;
import com.bakery.bakehouse.dto.CartResponseDTO;
import com.bakery.bakehouse.dto.CustomerRequestDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private OrderService orderService;  // ✅ Injecting OrderService

    // ✅ POST - Get cart by customer
    @PostMapping("/customer")
    public ResponseEntity<List<CartResponseDTO>> getCartByCustomer(@RequestBody CustomerRequestDTO customerRequest) {
        Integer custId = customerRequest.getCustId();

        List<Cart> cartItems = cartRepo.findByCustomer_CustId(custId);

        if (cartItems.isEmpty()) {
            return ResponseEntity.notFound().build();  // 404 if no items found
        }

        List<CartResponseDTO> response = cartItems.stream()
            .map(cart -> new CartResponseDTO(
                cart.getProduct().getPName(),
                cart.getCartQuantity(),
                cart.getCartPrice(),
                cart.getCartTotal()
            ))
            .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    // ✅ POST - Place order
    @PostMapping("/place")
    public ResponseEntity<String> placeOrder(@RequestBody CustomerRequestDTO request) {
        orderService.placeOrder(request.getCustId());
        return ResponseEntity.ok("Order placed successfully!");
    }
}
