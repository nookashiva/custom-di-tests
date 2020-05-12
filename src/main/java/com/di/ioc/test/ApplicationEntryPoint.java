package com.di.ioc.test;

import java.util.Collection;

import com.di.ioc.DependencyInjector;
import com.di.ioc.annotations.Service;
import com.di.ioc.annotations.StartUp;
import com.di.ioc.config.DependencyConfiguration;
import com.di.ioc.models.ServiceDetails;
import com.di.ioc.services.DependencyContainer;
import com.di.ioc.test.config.events.CustomScopeEventHandler;
import com.di.ioc.test.config.producers.StringConfigProducer;
import com.di.ioc.test.config.producers.StringConfigProducer2;
import com.di.ioc.test.contracts.Test;

@Service
public class ApplicationEntryPoint {

    public static DependencyContainer dependencyContainer;

    public static void main(String[] args) {
        DependencyInjector.run(ApplicationEntryPoint.class,
                new DependencyConfiguration()
                        .instantiations()
                        .addDependencyResolver(new StringConfigProducer())
                        .addDependencyResolver(new StringConfigProducer2())
                        .and()
                        .scanning()
                            .addServiceDetailsCreatedCallback(new CustomScopeEventHandler())
                        .and()
                        .build()
        );
    }

    @StartUp
    public void appStarted(DependencyContainer dependencyContainer) {
        ApplicationEntryPoint.dependencyContainer = dependencyContainer;
        System.out.println("Application Started");

        Collection<ServiceDetails> tests = dependencyContainer.getImplementations(Test.class);
        for (ServiceDetails test : tests) {
            this.runTest(test);
        }
    }

    private void runTest(ServiceDetails serviceDetails) {
        final Test test = (Test) serviceDetails.getInstance();

        System.out.println("Running tests from: " + serviceDetails.getServiceType().getName());
        test.runTest();

        System.out.println("\n");
    }
}
