package pl.raziel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.raziel.entity.Article;
import pl.raziel.entity.UserInfo;
import pl.raziel.repositories.ArticleRepository;
import pl.raziel.repositories.UserInfoRepository;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootSecurityThymeleafCsrfJpaApplication/* implements CommandLineRunner*/ {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityThymeleafCsrfJpaApplication.class, args);
    }

    @Bean
    CommandLineRunner articles(ArticleRepository repository) {
        return args -> {
            Article java = new Article();
            java.setArticleId(1);
            java.setTitle("Java Concurrency");
            java.setCategory("Java");
            Article hibernate = new Article();
            hibernate.setArticleId(2);
            hibernate.setTitle("Hibernate HQL");
            hibernate.setCategory("Hibernate");
            Article mvc = new Article();
            mvc.setArticleId(3);
            mvc.setTitle("Spring MVC with Hibernate");
            mvc.setCategory("Spring");
            Arrays.asList(java, hibernate, mvc).forEach(e -> repository.save(e));
        };
    }

    @Bean
    CommandLineRunner users(UserInfoRepository repository) {
        return args -> {
            UserInfo mukesh = new UserInfo();
            mukesh.setUserName("mukesh");
            mukesh.setPassword("$2a$10$N0eqNiuikWCy9ETQ1rdau.XEELcyEO7kukkfoiNISk/9F7gw6eB0W");
            mukesh.setFullName("Mukesh Sharma");
            mukesh.setRole("ROLE_ADMIN");
            mukesh.setCountry("India");
            mukesh.setEnabled((short) 1);
            UserInfo tarun = new UserInfo();
            tarun.setUserName("tarun");
            tarun.setPassword("$2a$10$QifQnP.XqXDW0Lc4hSqEg.GhTqZHoN2Y52/hoWr4I5ePxK7D2Pi8q");
            tarun.setFullName("Tarun Singh");
            tarun.setRole("ROLE_USER");
            tarun.setCountry("India");
            tarun.setEnabled((short) 1);

            Arrays.asList(mukesh, tarun).forEach(e -> repository.save(e));
        };
    }
}
