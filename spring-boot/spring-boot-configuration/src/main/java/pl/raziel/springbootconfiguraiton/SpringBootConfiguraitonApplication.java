package pl.raziel.springbootconfiguraiton;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@SpringBootApplication
public class SpringBootConfiguraitonApplication {

    Logger log = LoggerFactory.getLogger(SpringBootConfiguraitonApplication.class);

    public static void main(String[] args) {
//		SpringApplication.run(SpringBootConfiguraitonApplication.class, args);
        new SpringApplicationBuilder(SpringBootConfiguraitonApplication.class)/*.listeners(e -> log.info("### > " + e.getClass().getCanonicalName()))*/.run(args);
    }


    @Value("${server.ip}")
    String serverIp;

    @Autowired
    MyAppProperties props;

    @Bean
    CommandLineRunner values() {
        return args -> {
            log.info(" > The Server IP is: " + serverIp);
            log.info(" > App Name: " + props.getName());
            log.info(" > App Info: " + props.getDescription());
        };
    }

    @Component
    @ConfigurationProperties(prefix = "myapp")
    public static class MyAppProperties {
        private String name;
        private String description;
        private String serverIp;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getServerIp() {
            return serverIp;
        }

        public void setServerIp(String serverIp) {
            this.serverIp = serverIp;
        }
    }
}
