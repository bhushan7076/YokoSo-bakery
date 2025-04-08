package com.bakery.bakehouse.Controller;

import java.util.List;
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

@RestController
@RequestMapping("/products")
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
    public ResponseEntity<String> addToCart(@RequestBody CartRequestDTO cartRequestDTO) {
        Integer custId = cartRequestDTO.getCustId();
        Integer productId = cartRequestDTO.getProductId();
        int quantity = cartRequestDTO.getQuantity();

        if (custId == null) {
            return ResponseEntity.badRequest().body("Customer ID must not be null");
        }

        Optional<Customer> customer = customerRepo.findById(custId);
        if (customer.isEmpty()) {
            return ResponseEntity.badRequest().body("Customer not found");
        }

        Optional<Product> product = productRepo.findById(productId);
        if (product.isEmpty()) {
            return ResponseEntity.badRequest().body("Product not found");
        }

        Product selectedProduct = product.get();
        Double productPrice = selectedProduct.getPPrice();

        if (productPrice == null) {
            productPrice = 0.0; // Prevent null values
        }

        Double totalPrice = productPrice * quantity;

        Cart cart = new Cart();
        cart.setCustomer(customer.get());
        cart.setProduct(selectedProduct);
        cart.setCartQuantity(quantity);
        cart.setCartPrice(productPrice); // Ensure price is set
        cart.setCartTotal(totalPrice); // Ensure total price is set

        // Debugging logs
        System.out.println("----- Cart Debug Logs -----");
        System.out.println("Product Price: " + productPrice);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: " + totalPrice);
        System.out.println("Cart Object: " + cart);

        cartRepo.save(cart);
        return ResponseEntity.ok("Product added to cart successfully");
    }




}
