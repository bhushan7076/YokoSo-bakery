package com.bakery.bakehouse.Controller;



import com.bakery.bakehouse.Service.OrderService;
import com.bakery.bakehouse.dto.CustomerRequestDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity<String> placeOrder(@RequestBody CustomerRequestDTO request) {
        orderService.placeOrder(request.getCustId());
        return ResponseEntity.ok("Order placed successfully!");
    }
}
