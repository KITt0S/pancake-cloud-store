package pancakes.dao;

import org.springframework.data.repository.CrudRepository;
import pancakes.Pancake;

public interface PancakeRepository extends CrudRepository<Pancake, Long> {
}
