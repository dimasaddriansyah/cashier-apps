package apps.cashier.cashierapps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apps.cashier.cashierapps.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}

