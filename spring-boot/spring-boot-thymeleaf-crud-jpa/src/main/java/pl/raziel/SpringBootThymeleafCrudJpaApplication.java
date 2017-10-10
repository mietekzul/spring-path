package pl.raziel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.raziel.entities.Course;
import pl.raziel.entities.Student;
import pl.raziel.entities.User;
import pl.raziel.repositories.CourseRepository;
import pl.raziel.repositories.StudentRepository;
import pl.raziel.repositories.UserRepository;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringBootThymeleafCrudJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringBootThymeleafCrudJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootThymeleafCrudJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner initH2Database(StudentRepository repository, CourseRepository crepository, UserRepository urepository) {
        return (args) -> {
            // save students
            Student student1 = new Student("John", "Johnson", "IT", "john@john.com");
            repository.save(new Student("Steve", "Stevens", "IT", "steve.stevent@st.com"));
            repository.save(new Student("Mary", "Robinson", "IT", "mary@robinson.com"));
            repository.save(new Student("Kate", "Keystone", "Nursery", "kate@kate.com"));
            repository.save(new Student("Diana", "Doll", "Business", "diana@doll.com"));

            Course course1 = new Course("Programming Java");
            Course course2 = new Course("Spring Boot basics");
            crepository.save(new Course("Marketing 1"));
            crepository.save(new Course("Marketing 2"));

            crepository.save(course1);
            crepository.save(course2);

            Set<Course> courses = new HashSet<>();
            courses.add(course1);
            courses.add(course2);

            student1.setCourses(courses);
            repository.save(student1);

            // Create users with BCrypt encoded password (user/user, admin/admin)
            User user1 = new User("user", "$2a$10$/a4XyhiZuT7/8xv9iWJ02uLubrTbGJPS8RzQ1.Re.PTr.Hu65MmuW", "USER");
            User user2 = new User("admin", "$2a$10$n3LGFzhNneHSB9lTbap.ges5nx9MZQap5wAGINPWlyPYUhr/j9ZRi", "ADMIN");
            urepository.save(user1);
            urepository.save(user2);
        };
    }
}
