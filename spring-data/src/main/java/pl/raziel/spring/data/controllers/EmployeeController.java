package pl.raziel.spring.data.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.raziel.spring.data.entities.Employee;
import pl.raziel.spring.data.repositories.EmployeeRepository;

/**
 * Created by dlok on 02/06/2017.
 */
@RestController
@RequestMapping("employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping
    ResponseEntity<Iterable<Employee>> getEmployees() {
		final Iterable<Employee> employees = employeeRepository.findAll();

		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@GetMapping("{firstName}")
    ResponseEntity<Iterable<Employee>> findEmployeeByFirstName(@PathVariable("firstName") String firstName) {
		final Iterable<Employee> employees = employeeRepository.findByFirstName(firstName);
		employees.iterator().next();

		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@GetMapping("{firstName}/{lastName}")
    ResponseEntity<Iterable<Employee>> findEmployeeByFirstNameAndLastName(@PathVariable("firstName") String firstName,
                                                                          @PathVariable("lastName") String lastName) {
		final Iterable<Employee> employees = employeeRepository.findByFirstNameAndLastName(firstName, lastName);
		employees.iterator().next();

		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

}
