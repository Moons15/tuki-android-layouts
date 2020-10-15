package com.tuki.di.module;

import com.tuki.presentation.welcome.SignInFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class SignInFragmentProvider {

    @ContributesAndroidInjector(modules = SignInFragmentModule.class)
    abstract SignInFragment provideSignInFragmentFactory();
}
