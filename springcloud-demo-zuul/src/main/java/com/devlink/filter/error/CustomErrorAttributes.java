package com.devlink.filter.error;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @author wuxy@ieyecloud.com
 * @date 2018/3/14 16:20
 */
@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace){
        Map<String, Object> result = super.getErrorAttributes(webRequest, includeStackTrace);
        result.put("code", result.get("status"));
        result.put("msg", result.get("message"));
        //result.remove("error");
        //result.remove("exception");
        //result.remove("message");
        //result.remove("status");
        return result;
    }
}
