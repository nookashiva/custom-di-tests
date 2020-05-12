package com.di.ioc.test.tests.scopes.services;

import com.di.ioc.annotations.PostConstruct;
import com.di.ioc.annotations.Service;

@Service
public class DefaultScopedServiceImpl implements DefaultScopedService{

    private static int id = 0;

    private int instanceId;

    @PostConstruct
    public void init() {
        this.instanceId = ++id;
    }

    @Override
    public int getIdentity() {
        return this.instanceId;
    }
}
