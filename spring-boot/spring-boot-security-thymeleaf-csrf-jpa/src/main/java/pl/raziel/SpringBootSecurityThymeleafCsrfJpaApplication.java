package pl.raziel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.raziel.entity.Article;
import pl.raziel.entity.UserInfo;
import pl.raziel.repositories.ArticleRepository;
import pl.raziel.repositories.UserInfoRepository;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootSecurityThymeleafCsrfJpaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityThymeleafCsrfJpaApplication.class, args);
    }

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public void run(String... strings) throws Exception {
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
        Arrays.asList(java, hibernate, hibernate).forEach(e -> articleRepository.save(e));

        UserInfo mukesh = new UserInfo();
        mukesh.setUserName("mukesh");
        mukesh.setPassword("m123");
        mukesh.setFullName("Mukesh Sharma");
        mukesh.setRole("ROLE_ADMIN");
        mukesh.setCountry("India");
        mukesh.setEnabled((short) 1);
        UserInfo tarun = new UserInfo();
        tarun.setUserName("tarun");
        tarun.setPassword("t123");
        tarun.setFullName("Tarun Singh");
        tarun.setRole("ROLE_USER");
        tarun.setCountry("India");
        tarun.setEnabled((short) 1);

        Arrays.asList(mukesh).forEach(e -> userInfoRepository.save(e));
        userInfoRepository.findAll().stream().forEach(e -> System.out.println(e.getFullName()));
    }
}
