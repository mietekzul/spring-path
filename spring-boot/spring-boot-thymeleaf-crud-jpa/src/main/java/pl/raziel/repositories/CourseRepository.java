package pl.raziel.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.raziel.entities.Course;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {
    List<Course> findByName(String name);
}
