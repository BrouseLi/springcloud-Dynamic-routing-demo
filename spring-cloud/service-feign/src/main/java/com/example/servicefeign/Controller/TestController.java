package com.example.servicefeign.Controller;

import com.example.servicefeign.service.ServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private ServiceHi serviceHi;
    @GetMapping("/hello/{name}")
    public String home(@PathVariable String name){
        return serviceHi.sayHiFromServiceHi(name);
    }
}
