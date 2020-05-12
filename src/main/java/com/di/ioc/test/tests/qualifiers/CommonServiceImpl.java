package com.di.ioc.test.tests.qualifiers;

import com.di.ioc.annotations.NamedInstance;
import com.di.ioc.annotations.Service;

@Service
@NamedInstance("COMMON_NAME")
public class CommonServiceImpl implements CommonService {
    @Override
    public String getIdentity() {
        return "COMMON_SERVICE";
    }
}
