package com.tuki.di.module;

import com.tuki.presentation.welcome.SignInContract;
import com.tuki.presentation.welcome.SignInFragment;
import com.tuki.presentation.welcome.SignInPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class SignInFragmentModule {

    @Provides
    SignInContract.View provideSignInView(SignInFragment signInFragment) {
        return signInFragment;
    }

    @Provides
    SignInContract.Presenter provideSignInPresenter(SignInContract.View view) {
        return new SignInPresenterImpl(view);
    }
}
