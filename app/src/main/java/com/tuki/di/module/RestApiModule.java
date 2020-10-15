package com.tuki.di.module;

import com.tuki.BuildConfig;
import com.tuki.data.io.ServiceFactory;
import com.tuki.data.io.TukiService;

import dagger.Module;
import dagger.Provides;

@Module
public class RestApiModule {

    @Provides
    ServiceFactory provideServiceFactory() {
        return new ServiceFactory(BuildConfig.DEFAULT_TIMEOUT, BuildConfig.BASE_URL);
    }

    @Provides
    TukiService provideTukiService(ServiceFactory serviceFactory) {
        return serviceFactory.makeTukiService(BuildConfig.DEBUG);
    }
}
