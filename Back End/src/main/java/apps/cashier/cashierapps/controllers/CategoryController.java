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
import apps.cashier.cashierapps.entities.Category;
import apps.cashier.cashierapps.services.category.CategoryService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    // Get All
    @GetMapping("")
    public ResponseEntity<Object> get() {
        List<Category> categories = categoryService.getAll();
        return CustomResponse.generateResponse("Data found with total amount : " + categories.size(), HttpStatus.OK,
                categories);
    }

    // Get By ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id) {
        Category category = categoryService.getById(id);
        return CustomResponse.generateResponse("Data found", HttpStatus.OK, category);
    }

    // Add Category
    @PostMapping("")
    public ResponseEntity<Object> post(@RequestBody Category category) {
        categoryService.save(category);
        return CustomResponse.generateResponse("Success save data", HttpStatus.OK);
    }

    // Update Category
    @PutMapping("/{id}")
    public ResponseEntity<Object> put(@PathVariable(required = true) Integer id, @RequestBody Category category) {
        category.setId(id);
        categoryService.update(category);
        return CustomResponse.generateResponse("Success update data", HttpStatus.OK);
    }

    // Delete Category
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true) Integer id) {
        categoryService.delete(id);
        return CustomResponse.generateResponse("Success delete data", HttpStatus.OK);
    }
}
