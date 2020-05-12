package com.di.ioc.test.config.events;

import com.di.ioc.enums.ScopeType;
import com.di.ioc.events.ServiceDetailsCreated;
import com.di.ioc.models.ServiceDetails;
import com.di.ioc.test.config.annotations.CustomProxyScope;

public class CustomScopeEventHandler implements ServiceDetailsCreated {
    @Override
    public void serviceDetailsCreated(ServiceDetails serviceDetails) {
        if (serviceDetails.getServiceType().isAnnotationPresent(CustomProxyScope.class)) {
            serviceDetails.setScopeType(ScopeType.PROXY);
        }
    }
}
