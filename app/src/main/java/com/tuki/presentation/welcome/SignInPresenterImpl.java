package com.tuki.presentation.welcome;

public class SignInPresenterImpl implements SignInContract.Presenter {

    private final SignInContract.View view;

    public SignInPresenterImpl(SignInContract.View view) {
        this.view = view;
    }

    @Override
    public void makeLogin(String email, String password) {
        view.hideLoginButton();
        view.showProgress();

    }

    @Override
    public void makeFacebookLogin(String token) {
        view.hideLoginButton();
        view.showProgress();
    }

    @Override
    public void makeGoogleLogin(String token) {
        view.hideLoginButton();
        view.showProgress();
    }
}
