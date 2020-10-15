package com.tuki.presentation.welcome;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tuki.R;
import com.tuki.presentation.main.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerFragment;

public class SignInFragment extends DaggerFragment implements SignInContract.View {

    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.btnLoginFacebook)
    FrameLayout btnLoginFacebook;
    @BindView(R.id.btnLoginGoogle)
    FrameLayout btnLoginGoogle;

    @BindView(R.id.containerRegister)
    LinearLayout containerRegister;
    @BindView(R.id.progress)
    ProgressBar progressBar;

    @Inject
    SignInContract.Presenter presenter;


    public SignInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Make Logic
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });
        btnLoginFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Make Logic
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });
        btnLoginGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Make Logic
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });
        containerRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_signInFragment_to_signUpFragment);
            }
        });
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showErrorMessage(int resId) {
        Toast.makeText(getActivity(), getString(resId), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginButton() {
        btnLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoginButton() {
        btnLogin.setVisibility(View.GONE);
    }

    @Override
    public void moveOnLoginSuccess() {
        startActivity(new Intent(getActivity(), MainActivity.class));
    }
}
