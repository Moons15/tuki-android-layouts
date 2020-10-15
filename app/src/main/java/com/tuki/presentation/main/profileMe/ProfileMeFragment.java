package com.tuki.presentation.main.profileMe;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.tuki.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class ProfileMeFragment extends Fragment {

    @BindView(R.id.container_follow)
    FrameLayout btnFollow;
    @BindView(R.id.btn_settings)
    FrameLayout btnSettings;
    @BindView(R.id.btn_back)
    FrameLayout btnBack;

    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    private ProfileMePageAdapter profileMePageAdapter;

    public ProfileMeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_me, container, false);
        ButterKnife.bind(this, view);

        btnFollow.setVisibility(View.GONE);
        btnBack.setVisibility(View.GONE);

        registerForContextMenu(btnSettings);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getActivity(), v);
                popupMenu.getMenuInflater()
                        .inflate(R.menu.profile_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(ProfileMeFragment.this::onContextItemSelected);
                popupMenu.show();
            }
        });

        profileMePageAdapter = new ProfileMePageAdapter(getActivity(), getChildFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(profileMePageAdapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        String mesage = "";
        switch (item.getItemId()) {
            case R.id.menu_update_photo:
                mesage = "Se actualizó la foto";
                break;
            case R.id.menu_update_description:
                mesage = "Se actualizó la descripción";
                break;
            case R.id.menu_sign_out:
                mesage = "Se cerró la sesió";
                break;
        }

        Toast.makeText(getActivity(), mesage, Toast.LENGTH_SHORT).show();

        return true;

    }


}
