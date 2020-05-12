package com.di.ioc.test.tests.scopes.beans;


public class PrototypeScopeBean2 implements PrototypeScopeBean {

    private static int id = 55;

    private int instanceId;


    public PrototypeScopeBean2() {
        this.instanceId = ++id;
    }

    public int getIdentity() {
        return this.instanceId;
    }
}
