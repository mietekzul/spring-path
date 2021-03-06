package pl.raziel;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClient2Application {

    @Autowired
    private EurekaClient client;

    @RequestMapping("serviceinfo")
    public String serviceInfo() {
        InstanceInfo instance = client.getNextServerFromEureka("myOtherClient", false);
        return instance.getHomePageUrl();
    }

    @RequestMapping("service")
    public List<String> service() {
        return Arrays.asList("Value1", "Value2");
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaClient2Application.class, args);
    }
}
