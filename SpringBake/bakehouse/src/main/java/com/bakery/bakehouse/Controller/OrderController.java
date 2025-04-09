package com.bakery.bakehouse.Controller;

import com.bakery.bakehouse.Entity.Order;
import com.bakery.bakehouse.Service.OrderService;
import com.bakery.bakehouse.dto.OrderResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    
    // ✅ Get orders by customer ID
    @GetMapping("/customer/{custId}")
    public List<OrderResponseDTO> getOrdersByCustomerId(@PathVariable Integer custId) {
        List<Order> orders = orderService.getOrdersByCustomerId(custId);
        return orders.stream().map(OrderResponseDTO::new).collect(Collectors.toList());
    }
}
