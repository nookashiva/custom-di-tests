package com.di.ioc.test.tests.scopes.services;

import com.di.ioc.annotations.PostConstruct;
import com.di.ioc.annotations.Scope;
import com.di.ioc.annotations.Service;
import com.di.ioc.enums.ScopeType;

@Service
@Scope(ScopeType.PROTOTYPE)
public class PrototypeScopedServiceImpl implements PrototypeScopedService {

    private static int id = 0;

    private int instanceId;

    public PrototypeScopedServiceImpl() {
        int a = 10;
    }

    @PostConstruct
    public void init() {
        this.instanceId = ++id;
    }

    @Override
    public int getIdentity() {
        return this.instanceId;
    }
}
