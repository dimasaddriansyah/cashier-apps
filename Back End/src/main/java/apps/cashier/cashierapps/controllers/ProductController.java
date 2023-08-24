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
import apps.cashier.cashierapps.entities.Product;
import apps.cashier.cashierapps.services.product.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("api/products")
public class ProductController {
    private final ProductService productService;

    // Get All
    @GetMapping("")
    public ResponseEntity<Object> get() {
        List<Product> products = productService.getAll();
        return CustomResponse.generateResponse("Data found with total amount : " + products.size(), HttpStatus.OK,
                products);
    }

    // Get By ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) String id) {
        Product product = productService.getById(id);
        return CustomResponse.generateResponse("Data found", HttpStatus.OK, product);
    }

    // Add Product
    @PostMapping("")
    public ResponseEntity<Object> post(@RequestBody Product product) {
        productService.save(product);
        return CustomResponse.generateResponse("Success save data", HttpStatus.OK);
    }

    // Update Product
    @PutMapping("/{id}")
    public ResponseEntity<Object> put(@PathVariable(required = true) String id, @RequestBody Product product) {
        product.setId(id);
        productService.update(product);
        return CustomResponse.generateResponse("Success update data", HttpStatus.OK);
    }

    // Delete Product
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true) String id) {
        productService.delete(id);
        return CustomResponse.generateResponse("Success delete data", HttpStatus.OK);
    }
}
