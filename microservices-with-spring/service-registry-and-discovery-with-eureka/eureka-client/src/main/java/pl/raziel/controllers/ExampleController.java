package pl.raziel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ExampleController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("execute")
    public String execute() {
        return restTemplate.getForObject("http://MYOTHERCLIENT/serviceinfo", String.class);
    }
}
