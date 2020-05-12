package com.di.ioc.test.tests.scopes.beans;

import com.di.ioc.annotations.Bean;
import com.di.ioc.annotations.NamedInstance;
import com.di.ioc.annotations.Scope;
import com.di.ioc.annotations.Service;
import com.di.ioc.enums.ScopeType;

@Service
public class BeanConfig {

    @Bean
    @Scope(ScopeType.PROTOTYPE)
    @NamedInstance("bean_1")
    public PrototypeScopeBean proxyScopeBean() {
        return new PrototypeScopeBean1();
    }

    @Bean
    @Scope(ScopeType.PROTOTYPE)
    @NamedInstance("bean_2")
    public PrototypeScopeBean proxyScopeBean2() {
        return new PrototypeScopeBean2();
    }
}
