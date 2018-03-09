package com.devlink;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DemoService1Controller {
    private final static Map<String, String> credentials = new HashMap<>();
    static{
        credentials.put("jack", "passwd1");
        credentials.put("ray", "passwd2");
        credentials.put("ron", "passwd3");
    }

    @RequestMapping(value = "auth", method = RequestMethod.GET)
    public Boolean auth(@RequestParam String username, @RequestParam String password){
        if(!credentials.containsKey(username)){
            return false;
        }

        if(!credentials.get(username).equals(password)){
            return false;
        }

        return true;
    }
}
