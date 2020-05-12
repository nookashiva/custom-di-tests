package com.di.ioc.test.tests.proxies.services;

import com.di.ioc.annotations.PostConstruct;
import com.di.ioc.annotations.Scope;
import com.di.ioc.annotations.Service;
import com.di.ioc.enums.ScopeType;

@Service
@Scope(ScopeType.PROXY)
public class ConcreteProxyService {

    private static int id = 0;

    private int instanceId;

    @PostConstruct
    public void onInt() {
        this.instanceId = ++id;
    }


    public int getIdentity() {
        return this.instanceId;
    }
}
