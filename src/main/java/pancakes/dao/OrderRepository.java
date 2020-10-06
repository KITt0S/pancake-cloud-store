package pancakes.dao;

import org.springframework.data.repository.CrudRepository;
import pancakes.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
