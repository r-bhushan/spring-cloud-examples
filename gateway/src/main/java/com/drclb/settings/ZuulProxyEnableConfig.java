package com.drclb.settings;

import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("!test2")
@EnableZuulProxy
@Configuration
public class ZuulProxyEnableConfig {
}
