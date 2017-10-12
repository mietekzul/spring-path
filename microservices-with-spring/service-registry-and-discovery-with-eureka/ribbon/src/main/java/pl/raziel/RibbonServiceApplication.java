package pl.raziel;

import config.ServiceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RibbonClient(name = "service-for-ribbon", configuration = ServiceConfiguration.class)
public class RibbonServiceApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("startRibbonClient")
    public String startRibbonClient() {
        return restTemplate.getForObject("http://service-for-ribbon/execute", String.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(RibbonServiceApplication.class, args);
    }
}
