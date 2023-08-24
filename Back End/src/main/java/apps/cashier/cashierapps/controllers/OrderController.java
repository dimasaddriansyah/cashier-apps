package apps.cashier.cashierapps.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apps.cashier.cashierapps.dto.CustomResponse;
import apps.cashier.cashierapps.entities.Order;
import apps.cashier.cashierapps.services.order.OrderService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("api/orders")
public class OrderController {
    private final OrderService orderService;

    // Get All
    @GetMapping("")
    public ResponseEntity<Object> get() {
        List<Order> orders = orderService.getAll();
        return CustomResponse.generateResponse("Data found with total amount : " + orders.size(), HttpStatus.OK,
                orders);
    }

    // Get By ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id) {
        Order order = orderService.getById(id);
        return CustomResponse.generateResponse("Data found", HttpStatus.OK, order);
    }

    // Add Order
    @PostMapping("")
    public ResponseEntity<Object> post(@RequestBody Order order) {
        orderService.save(order);
        return CustomResponse.generateResponse("Success save data", HttpStatus.OK);
    }

    // Update Order
    @PutMapping("/{id}")
    public ResponseEntity<Object> put(@PathVariable(required = true) Integer id, @RequestBody Order order) {
        order.setId(id);
        orderService.update(order);
        return CustomResponse.generateResponse("Success update data", HttpStatus.OK);
    }

    // Delete Order
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true) Integer id) {
        orderService.delete(id);
        return CustomResponse.generateResponse("Success delete data", HttpStatus.OK);
    }
}
