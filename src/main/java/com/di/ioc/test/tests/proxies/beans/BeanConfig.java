package com.di.ioc.test.tests.proxies.beans;

import com.di.ioc.annotations.Bean;
import com.di.ioc.annotations.Scope;
import com.di.ioc.annotations.Service;
import com.di.ioc.enums.ScopeType;

@Service
public class BeanConfig {

    @Bean
    @Scope(ScopeType.PROXY)
    public NonProxiedBean nonProxiedBean() {
        return new NonProxiedBean();
    }

    @Bean
    @Scope(ScopeType.PROXY)
    public ProxyBean proxyBean() {
        return new ProxyBeanImpl();
    }
}
