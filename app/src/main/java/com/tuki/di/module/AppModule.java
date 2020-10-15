package com.tuki.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.tuki.common.Const;
import com.tuki.data.DataExecutionThread;
import com.tuki.di.ThreadTask;
import com.tuki.di.qualifier.ExecuteOn;
import com.tuki.presentation.GuiExecutionThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;


@Module
public class AppModule {

    @Provides
    @ExecuteOn(ThreadTask.GUI)
    @Singleton
    Scheduler provideGuiScheduler() {
        return new GuiExecutionThread().get();
    }

    @Provides
    @ExecuteOn(ThreadTask.DATA)
    @Singleton
    Scheduler provideDataScheduler() {
        return new DataExecutionThread().get();
    }

    @Provides
    @ExecuteOn(ThreadTask.SINGLE)
    @Singleton
    Scheduler provideSingleScheduler() {
        return Schedulers.single();
    }

    @Provides
    @Singleton
    Context provideContext(Application app) {
        return app.getApplicationContext();
    }


    @Provides
    @Singleton
    SharedPreferences providePreferences(Context context) {
        return context.getSharedPreferences(Const.System.DEFAULT_PREFERENCES, Context.MODE_PRIVATE);
    }

}
