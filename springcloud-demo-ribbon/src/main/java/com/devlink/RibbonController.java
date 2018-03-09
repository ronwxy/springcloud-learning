package com.devlink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "check-auth", method = RequestMethod.GET)
    public String checkAuth(@RequestParam String username, @RequestParam String passwd){
        String url = "http://service1/auth?username="+username+"&password="+passwd;
        Boolean result = restTemplate.getForObject(url, Boolean.class);
        if(result){
            return "恭喜，认证成功！";
        }else{
            return "对不起，认证失败了！";
        }
    }
}
