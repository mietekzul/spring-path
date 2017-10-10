package pl.raziel.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.raziel.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
