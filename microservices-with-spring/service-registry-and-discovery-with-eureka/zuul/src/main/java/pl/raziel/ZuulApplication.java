package pl.raziel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import pl.raziel.filters.MyZuulFilter;

@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {

    @Bean
    public MyZuulFilter filter() {
        return new MyZuulFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
