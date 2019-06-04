package com.drclb.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;

/**
 * This filter override {@link org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter}
 */
public class ExceptionTracerFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.ERROR_TYPE;
    }

    @Override
    public int filterOrder() {
        return -1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context  = RequestContext.getCurrentContext();
        Throwable throwable = context.getThrowable();
        context.setResponseStatusCode(HttpStatus.OK.value());
        context.setResponseBody(throwable.getCause().toString());
        context.remove("throwable");
        return null;
    }
}
