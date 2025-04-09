package com.bakery.bakehouse.Controller;



import com.bakery.bakehouse.Entity.Customer;
import com.bakery.bakehouse.Repo.CustomerRepo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepository;

    // Signup (Register Customer)
    /*@PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody Customer customer) {
        // Check if email or username already exists
        if (customerRepository.findByCustEmail(customer.getCustEmail()) != null ||
            customerRepository.findByCustUsername(customer.getCustUsername()) != null) {
            return ResponseEntity.badRequest().body("Email or Username already exists!");
        }

        // Save customer data
        Customer savedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok("Signup successful! Customer ID: " + savedCustomer.getCustId());
    }*/
    
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody Customer customer) {
        if (customerRepository.findByCustEmail(customer.getCustEmail()) != null ||
            customerRepository.findByCustUsername(customer.getCustUsername()) != null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Email or Username already exists!"));
        }

        Customer savedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(Map.of(
            "message", "Signup successful!",
            "customerId", savedCustomer.getCustId()
        ));
    }


    // Signin (Authenticate Customer)
    /*@PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody Customer customer) {
        Customer foundCustomer = customerRepository.findByCustUsername(customer.getCustUsername());
        
        if (foundCustomer != null && foundCustomer.getCustPassword().equals(customer.getCustPassword())) {
            return ResponseEntity.ok("Login successful! Customer ID: " + foundCustomer.getCustId());
        } else {
            return ResponseEntity.badRequest().body("Invalid username or password!");
        }
    }*/
    
    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody Customer customer) {
        Customer foundCustomer = customerRepository.findByCustUsername(customer.getCustUsername());

        if (foundCustomer != null && foundCustomer.getCustPassword().equals(customer.getCustPassword())) {
            return ResponseEntity.ok(Map.of(
                "message", "Login successful!",
                "customerId", foundCustomer.getCustId()
            ));
        } else {
            return ResponseEntity.badRequest().body(Map.of("error", "Invalid username or password!"));
        }
    }

}
