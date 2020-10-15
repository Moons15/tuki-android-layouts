package com.tuki.presentation.welcome;

public interface SignInContract {

    interface View {

        void showProgress();

        void hideProgress();

        void showErrorMessage(int resId);

        void showLoginButton();

        void hideLoginButton();

        void moveOnLoginSuccess();

    }

    interface Presenter {

        void makeLogin(String email, String password);

        void makeFacebookLogin(String token);

        void makeGoogleLogin(String token);
    }

}
