package apps.cashier.cashierapps.services;

import java.util.List;

public interface GenericService <E, T>{

    List<E> getAll();
    E getById(T id);
    E save(E entity);
    E update(E entity);
    Boolean delete(T id);
}
