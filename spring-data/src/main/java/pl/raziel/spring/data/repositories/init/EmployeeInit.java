package pl.raziel.spring.data.repositories.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.raziel.spring.data.entities.Employee;
import pl.raziel.spring.data.repositories.EmployeeRepository;
import pl.raziel.spring.data.utils.EmployeeGenerator;

import java.util.List;

/**
 * Created by dlok on 02/06/2017.
 */
@Component
public class EmployeeInit implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeGenerator employeeGenerator;

	@Override
	public void run(String... args) throws Exception {

		List<Employee> employees = employeeGenerator.generate(200);

		employees.stream().forEach(employee -> employeeRepository.save(employee));
	}
}
