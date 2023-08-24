package apps.cashier.cashierapps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apps.cashier.cashierapps.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
