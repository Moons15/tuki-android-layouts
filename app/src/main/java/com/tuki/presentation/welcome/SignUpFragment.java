package com.tuki.presentation.welcome;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.tuki.R;
import com.tuki.presentation.main.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpFragment extends Fragment {

    @BindView(R.id.btnRegister)
    Button btnRegister;
    @BindView(R.id.containerSignIn)
    LinearLayout containerSignIn;

    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Make Logic
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });

        containerSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_signUpFragment_to_signInFragment);
            }
        });

    }
}
