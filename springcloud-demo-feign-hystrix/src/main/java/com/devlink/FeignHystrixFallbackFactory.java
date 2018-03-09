package com.devlink;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class FeignHystrixFallbackFactory implements FallbackFactory<FeignHystrixService> {
    @Override
    public FeignHystrixService create(Throwable throwable) {
        return new FeignHystrixService() {
            @Override
            public Boolean auth(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
                System.out.print("Throwable: " + throwable);
                return false;
            }
        };
    }
}
