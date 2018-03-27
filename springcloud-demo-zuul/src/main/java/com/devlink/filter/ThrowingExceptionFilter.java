package com.devlink.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

/**
 * @author wuxy@ieyecloud.com
 * @date 2018/3/14 15:21
 */
//@Component
public class ThrowingExceptionFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        throw new RuntimeException();
        //return null;
    }
}
