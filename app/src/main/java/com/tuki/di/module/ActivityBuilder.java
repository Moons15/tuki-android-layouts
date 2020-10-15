package com.tuki.di.module;

import com.tuki.presentation.welcome.WelcomeActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {
            WelcomeActivityModule.class,
            SignInFragmentProvider.class})
    abstract WelcomeActivity bindWelcomeActivity();
}
