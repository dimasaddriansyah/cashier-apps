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
import apps.cashier.cashierapps.entities.Cart;
import apps.cashier.cashierapps.services.cart.CartService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("api/carts")
public class CartController {
    private final CartService cartService;

    // Get All
    @GetMapping("")
    public ResponseEntity<Object> get() {
        List<Cart> carts = cartService.getAll();
        return CustomResponse.generateResponse("Data found with total amount : " + carts.size(), HttpStatus.OK,
                carts);
    }

    // Get By ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id) {
        Cart cart = cartService.getById(id);
        return CustomResponse.generateResponse("Data found", HttpStatus.OK, cart);
    }

    // Add Cart
    @PostMapping("")
    public ResponseEntity<Object> post(@RequestBody Cart cart) {
        cartService.save(cart);
        return CustomResponse.generateResponse("Success save data", HttpStatus.OK);
    }

    // Update Cart
    @PutMapping("/{id}")
    public ResponseEntity<Object> put(@PathVariable(required = true) Integer id, @RequestBody Cart cart) {
        cart.setId(id);
        cartService.update(cart);
        return CustomResponse.generateResponse("Success update data", HttpStatus.OK);
    }

    // Delete Cart
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true) Integer id) {
        cartService.delete(id);
        return CustomResponse.generateResponse("Success delete data", HttpStatus.OK);
    }
}
