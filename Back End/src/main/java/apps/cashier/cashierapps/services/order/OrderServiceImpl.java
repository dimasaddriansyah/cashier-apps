package apps.cashier.cashierapps.services.order;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import apps.cashier.cashierapps.entities.Order;
import apps.cashier.cashierapps.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getById(Integer id) {
        return orderRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Order with id " + id + " not found"));
    }

    @Override
    public Order save(Order entity) {
        return orderRepository.save(entity);
    }

    @Override
    public Order update(Order entity) {
        return orderRepository.save(entity);
    }

    @Override
    public Boolean delete(Integer id) {
        orderRepository.deleteById(id);
        return orderRepository.findById(id).isEmpty();
    }
}
