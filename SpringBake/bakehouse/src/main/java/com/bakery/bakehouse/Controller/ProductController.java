package com.bakery.bakehouse.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bakery.bakehouse.Entity.Cart;
import com.bakery.bakehouse.Entity.Customer;
import com.bakery.bakehouse.Entity.Product;
import com.bakery.bakehouse.Repo.CartRepo;
import com.bakery.bakehouse.Repo.CustomerRepo;
import com.bakery.bakehouse.Repo.ProductRepo;
import com.bakery.bakehouse.dto.CartRequestDTO;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/customer")
public class ProductController {

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private CustomerRepo customerRepo;
    
    @Autowired
    private ProductRepo productRepo;

    // Get all products
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return ResponseEntity.ok(products);
    }
    
    @PostMapping("/addToCart")
    public ResponseEntity<Map<String, String>> addToCart(@RequestBody CartRequestDTO cartRequestDTO) {
        Integer custId = cartRequestDTO.getCustId();
        Integer productId = cartRequestDTO.getProductId();
        int quantity = cartRequestDTO.getQuantity();

        if (custId == null) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Customer ID must not be null");
            return ResponseEntity.badRequest().body(errorResponse);
        }

        Optional<Customer> customer = customerRepo.findById(custId);
        if (customer.isEmpty()) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Customer not found");
            return ResponseEntity.badRequest().body(errorResponse);
        }

        Optional<Product> product = productRepo.findById(productId);
        if (product.isEmpty()) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Product not found");
            return ResponseEntity.badRequest().body(errorResponse);
        }

        Product selectedProduct = product.get();
        Double productPrice = selectedProduct.getPPrice();
        if (productPrice == null) {
            productPrice = 0.0;
        }

        Double totalPrice = productPrice * quantity;

        Cart cart = new Cart();
        cart.setCustomer(customer.get());
        cart.setProduct(selectedProduct);
        cart.setCartQuantity(quantity);
        cart.setCartPrice(productPrice);
        cart.setCartTotal(totalPrice);

        cartRepo.save(cart);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Product added to cart successfully");
        return ResponseEntity.ok().body(response);
    }



}
