package pl.raziel.spring.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.raziel.spring.data.entities.MongoBook;

public interface MongoBookRepository extends MongoRepository<MongoBook, Long> {

    MongoBook findByTitle(String title);
}
