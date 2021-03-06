package com.di.ioc.test.tests.resolvers.services;

import com.di.ioc.annotations.NamedInstance;
import com.di.ioc.annotations.Service;
import com.di.ioc.test.config.annotations.Resource;

@Service
@NamedInstance("third")
public class ThirdOptionService implements OptionService {

    private final String option;

    public ThirdOptionService(@Resource("opt3") String option) {
        this.option = option;
    }

    @Override
    public String getOption() {
        return this.option;
    }
}
