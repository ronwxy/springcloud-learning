package com.devlink.filter.error;

import com.netflix.zuul.FilterProcessor;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;

/**
 * @author wuxy@ieyecloud.com
 * @date 2018/3/14 16:23
 */
public class CustomFilterProcessor extends FilterProcessor {

    @Override
    public Object processZuulFilter(ZuulFilter filter) throws ZuulException {
        try{
            return super.processZuulFilter(filter);
        } catch(ZuulException e){
            throw new ZuulRuntimeException(e);
        } catch(Exception e){
            throw new ZuulRuntimeException(e);
        }
    }
}
