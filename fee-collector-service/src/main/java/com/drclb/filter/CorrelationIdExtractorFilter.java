package com.drclb.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

//import org.apache.log4j.Logger;
import com.drclb.config.CorrelationThreadLocal;
import org.springframework.stereotype.Component;

@Component
public class CorrelationIdExtractorFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        CorrelationThreadLocal.setCorrelationID(((HttpServletRequest) request).getHeader("X-C-ID"));
        chain.doFilter(request, response);
    }

}
