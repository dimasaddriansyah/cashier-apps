package apps.cashier.cashierapps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apps.cashier.cashierapps.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}
