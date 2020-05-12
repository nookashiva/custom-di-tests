package com.di.ioc.test.tests.qualifiers;

import com.di.ioc.annotations.Bean;
import com.di.ioc.annotations.NamedInstance;
import com.di.ioc.annotations.Service;

@Service
public class BeanConfig {

    @Bean
    @NamedInstance("COMMON_NAME")
    public CommonBean commonBean() {
        return new CommonBean();
    }
}
