package pl.raziel.spring.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
//@EnableWebSecurity
@ImportResource({"classpath*:WEB-INF/spring/security-context.xml", "classpath*:WEB-INF/spring/dispatcher-servlet.xml", "classpath*:WEB-INF/spring/application-context.xml"})
@EnableGlobalMethodSecurity
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }
}
