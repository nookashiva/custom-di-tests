package com.di.ioc.test.tests.callbacks.services;

import com.di.ioc.annotations.Service;
import com.di.ioc.test.config.annotations.CustomProxyScope;

@Service
@CustomProxyScope
public class CustomScopedServiceImpl implements CustomScopedService {
}
