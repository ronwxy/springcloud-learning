package com.devlink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
    @Autowired
    private FeignService authService;

    @RequestMapping(value = "check-auth", method = RequestMethod.GET)
    public String checkAuth(@RequestParam String username, @RequestParam String passwd){
        Boolean result = authService.auth(username, passwd);
        if(result){
            return "恭喜，认证成功！";
        }else{
            return "对不起，认证失败了！";
        }
    }
}
