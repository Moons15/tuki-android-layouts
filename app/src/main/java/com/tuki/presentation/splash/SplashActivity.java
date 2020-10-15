package com.tuki.presentation.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.tuki.R;
import com.tuki.presentation.welcome.WelcomeActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(() ->
                {
                    startActivity(new Intent(SplashActivity.this, WelcomeActivity.class));
                    finish();
                }
                , 3000);
    }
}
