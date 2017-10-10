package pl.raziel.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.raziel.entities.Student;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findByLastName(String lastname);
}
