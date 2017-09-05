package pl.raziel.spring.data.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.raziel.spring.data.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	Iterable<Employee> findByFirstName(String firstName);

	Iterable<Employee> findByFirstNameAndLastName(String firstName, String lastName);
}
