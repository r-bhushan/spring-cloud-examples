package com.drclb.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;
@Component
public class CorrelationIdFilter extends ZuulFilter {
    private static final String CORRELATION_ID_HEADER = "X-C-ID";
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
//        String cID = request.getHeader(CORRELATION_ID_HEADER);
//        if(StringUtils.isBlank(cID))
//        {
            ctx.addZuulRequestHeader(CORRELATION_ID_HEADER,UUID.randomUUID().toString());
//        }
        return null;
    }
}
