package apps.cashier.cashierapps.services.product;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import apps.cashier.cashierapps.entities.Product;
import apps.cashier.cashierapps.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(String id) {
        return productRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "category with id " + id + " not found"));
    }

    @Override
    public Product save(Product entity) {
        return productRepository.save(entity);
    }

    @Override
    public Product update(Product entity) {
        return productRepository.save(entity);
    }

    @Override
    public Boolean delete(String id) {
        productRepository.deleteById(id);
        return productRepository.findById(id).isEmpty();
    }
}
