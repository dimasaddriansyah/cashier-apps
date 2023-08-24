package apps.cashier.cashierapps.services.category;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import apps.cashier.cashierapps.entities.Category;
import apps.cashier.cashierapps.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "category with id " + id + " not found"));
    }

    @Override
    public Category save(Category entity) {
        return categoryRepository.save(entity);
    }

    @Override
    public Category update(Category entity) {
        return categoryRepository.save(entity);
    }

    @Override
    public Boolean delete(Integer id) {
        categoryRepository.deleteById(id);
        return categoryRepository.findById(id).isEmpty();
    }
}
