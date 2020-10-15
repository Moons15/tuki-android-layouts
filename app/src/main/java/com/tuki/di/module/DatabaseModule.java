package com.tuki.di.module;

import android.app.Application;

import com.tuki.data.io.TukiDatabase;

import dagger.Module;
import dagger.Provides;


@Module
public class DatabaseModule {

    @Provides
    TukiDatabase provideSdsDatabase(Application app) {
        return TukiDatabase.getInstance(app.getApplicationContext());
    }

}
