package com.devlink;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service1")
public interface FeignService {

    @RequestMapping(value = "auth", method = RequestMethod.GET)
    Boolean auth(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password);
}
