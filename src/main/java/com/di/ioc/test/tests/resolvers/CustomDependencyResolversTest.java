package com.di.ioc.test.tests.resolvers;

import com.di.ioc.annotations.Autowired;
import com.di.ioc.annotations.Qualifier;
import com.di.ioc.annotations.Service;
import com.di.ioc.test.asserts.Assert;
import com.di.ioc.test.contracts.Test;
import com.di.ioc.test.tests.resolvers.services.OptionService;

@Service
public class CustomDependencyResolversTest implements Test {

    @Autowired
    @Qualifier("first")
    private OptionService firstOptionService;

    @Autowired
    @Qualifier("second")
    private OptionService secondOptionService;

    @Autowired
    @Qualifier("third")
    private OptionService thirdOptionService;

    @Override
    public void runTest() {
        Assert.equal(
                "Should resolve custom resource dependency",
                "1",
                this.firstOptionService.getOption(),
                "Invalid custom dependency handler injection!"
        );

        Assert.equal(
                "Should resolve custom resource dependency",
                "2",
                this.secondOptionService.getOption(),
                "Invalid custom dependency handler injection!"
        );

        Assert.equal(
                "Should resolve custom resource dependency",
                "3",
                this.thirdOptionService.getOption(),
                "Invalid custom dependency handler injection!"
        );
    }
}
