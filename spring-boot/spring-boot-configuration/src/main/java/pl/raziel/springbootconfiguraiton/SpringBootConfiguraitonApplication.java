package pl.raziel.springbootconfiguraiton;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
public class SpringBootConfiguraitonApplication {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(SpringBootConfiguraitonApplication.class);
        app.setBanner((environment, sourceClass, out) -> out.print("\n\n\tThis is my own banner!\n\n".toUpperCase()));
        app.run(args);
    }
}
