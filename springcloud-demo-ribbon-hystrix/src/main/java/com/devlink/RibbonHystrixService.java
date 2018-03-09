package com.devlink;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonHystrixService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "authFallback")
    public Boolean auth(@RequestParam String username, @RequestParam String passwd){
        String url = "http://service1/auth?username="+username+"&password="+passwd;
        return restTemplate.getForObject(url, Boolean.class);
    }

    public Boolean authFallback(String username, String passwd){
        return false;
    }
}
