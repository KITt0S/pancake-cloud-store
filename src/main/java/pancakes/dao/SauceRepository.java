package pancakes.dao;

import org.springframework.data.repository.CrudRepository;
import pancakes.Sauce;

public interface SauceRepository extends CrudRepository<Sauce, Long> {
}
