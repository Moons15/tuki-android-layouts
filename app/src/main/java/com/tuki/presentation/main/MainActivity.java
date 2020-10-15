package com.tuki.presentation.main;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tuki.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.nav_view)
    BottomNavigationView navigationView;

    private NavController navController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        navController = Navigation.findNavController(this, R.id.nav_host_main);
        NavigationUI.setupWithNavController(navigationView, navController);
    }


}
