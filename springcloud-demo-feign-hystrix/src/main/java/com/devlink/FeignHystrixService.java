package com.devlink;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service1", fallbackFactory = FeignHystrixFallbackFactory.class)
public interface FeignHystrixService {

    @RequestMapping(value = "auth", method = RequestMethod.GET)
    Boolean auth(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password);
}
