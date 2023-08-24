package apps.cashier.cashierapps.services.cart;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import apps.cashier.cashierapps.entities.Cart;
import apps.cashier.cashierapps.repositories.CartRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;

    @Override
    public List<Cart> getAll() {
        return cartRepository.findAll();
    }

    @Override
    public Cart getById(Integer id) {
        return cartRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "cart with id " + id + " not found"));
    }

    @Override
    public Cart save(Cart entity) {
        return cartRepository.save(entity);
    }

    @Override
    public Cart update(Cart entity) {
        return cartRepository.save(entity);
    }

    @Override
    public Boolean delete(Integer id) {
        cartRepository.deleteById(id);
        return cartRepository.findById(id).isEmpty();
    }
}