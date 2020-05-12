package com.di.ioc.test.tests.beans;

import com.di.ioc.annotations.Bean;
import com.di.ioc.annotations.NamedInstance;
import com.di.ioc.annotations.Service;

@Service
public class BeanConfig {

    @Bean
    @NamedInstance("bean_1")
    public SomeInterfaceBean someBean1() {
        return new SomeInterfaceBeanImpl1();
    }

    @Bean
    @NamedInstance("bean_2")
    public SomeInterfaceBean someBean2() {
        return new SomeInterfaceBeanImpl2();
    }
}
