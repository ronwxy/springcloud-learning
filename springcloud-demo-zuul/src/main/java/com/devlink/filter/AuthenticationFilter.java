package com.devlink.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * @author wuxy@ieyecloud.com
 * @date 2017/9/28 10:55
 */
@Component
public class AuthenticationFilter extends ZuulFilter {

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
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String token = ctx.getRequest().getParameter("token");

        if(StringUtils.isBlank(token)){
            ZuulException ex = new ZuulException("操作未授权", HttpServletResponse.SC_UNAUTHORIZED, "token is null.");
            throw new ZuulRuntimeException(ex);
        }
        return null;

    }
}
