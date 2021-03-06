package com.di.ioc.test.config.producers;

import com.di.ioc.handlers.DependencyResolver;
import com.di.ioc.models.DependencyParam;
import com.di.ioc.test.config.annotations.Resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringConfigProducer2 implements DependencyResolver {
    private static final List<String> supportedCommands = new ArrayList<String>() {{
        add("opt3");
    }};

    @Override
    public boolean canResolve(DependencyParam dependencyParam) {
        return dependencyParam.getDependencyType() == String.class && hasAnnotation(dependencyParam)
                && supportedCommands.contains(getAnnotation(dependencyParam).value());
    }

    private boolean hasAnnotation(DependencyParam dependencyParam) {
        return Arrays.stream(dependencyParam.getAnnotations())
                .anyMatch(a -> a.annotationType() == Resource.class);
    }

    @Override
    public Object resolve(DependencyParam dependencyParam) {
        final String val = getAnnotation(dependencyParam).value();

        if ("opt3".equals(val.toLowerCase())) {
            return "3";
        }

        return null;
    }

    private Resource getAnnotation(DependencyParam dependencyParam) {
        return (Resource) Arrays.stream(dependencyParam.getAnnotations())
                .filter(a -> a.annotationType() == Resource.class)
                .findFirst().orElseThrow(RuntimeException::new);
    }
}
