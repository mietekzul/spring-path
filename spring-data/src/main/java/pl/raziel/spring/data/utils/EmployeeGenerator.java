package pl.raziel.spring.data.utils;

import org.springframework.stereotype.Service;
import pl.raziel.spring.data.entities.Employee;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by dlok on 02/06/2017.
 */
@Service
public class EmployeeGenerator {
	private static final String FIRST_NAMES_FILE_PATH = "firstNames";
	private static final double SALARY_BASE = 1_000.0;
	private static final double SALARY_SPREAD = 10_000.0;
	private final FileLinesLoader fileLinesLoader;
	private List<String> firstNames;
	private List<String> lastNames;
	private final Random random = new Random();

	public EmployeeGenerator(FileLinesLoader fileLinesLoader) {
		this.fileLinesLoader = fileLinesLoader;
	}

	public List<Employee> generate(int numberOfEmployees) {
		return Stream
				.generate(this::generate)
				.limit(numberOfEmployees)
				.collect(Collectors.toList());
	}

	private Employee generate() {
		Employee employee = new Employee();
		employee.setFirstName(getRandomFirstName());
		employee.setLastName(getRandomLastName());
		employee.setSalary(getRandomSalary());
		return employee;
	}

	private String getRandomFirstName() {
		return getRandom(getFirstNames());
	}

	private String getRandomLastName() {
		return getRandom(getLastNames());
	}

	private String getRandom(List<String> elements) {
		return elements.get(
				random.nextInt(
						elements.size()));
	}

	private List<String> getFirstNames() {
		if (firstNames == null) {
			firstNames = fileLinesLoader.loadLines(FIRST_NAMES_FILE_PATH);
		}
		return firstNames;
	}

	private List<String> getLastNames() {
		if (lastNames == null) {
			lastNames = fileLinesLoader.loadLines("lastNames");
		}
		return lastNames;
	}

	private BigDecimal getRandomSalary() {
		return new BigDecimal(SALARY_BASE + Math.random() * SALARY_SPREAD);
	}
}

