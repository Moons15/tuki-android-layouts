package com.tuki.presentation;


import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.transition.TransitionInflater;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.tuki.R;
import com.tuki.presentation.main.profileMe.ProfileOtherPageAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

import static androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileOtherFragment extends Fragment {

    @BindView(R.id.container_follow)
    FrameLayout containerFollow;
    @BindView(R.id.btn_follow)
    TextView btnFollow;
    @BindView(R.id.btn_following)
    TextView btnFollowing;
    @BindView(R.id.btn_settings)
    FrameLayout btnSettings;
    @BindView(R.id.btn_back)
    FrameLayout btnBack;

    @BindView(R.id.iv_profile)
    ImageView ivProfile;

    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    private ProfileOtherPageAdapter profileOtherPageAdapter;

    private int type;

    public ProfileOtherFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getArguments().getInt("typeContact");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_other, container, false);
        ButterKnife.bind(this, view);

        if (type == 0) {
            btnFollow.setVisibility(View.GONE);
            btnFollowing.setVisibility(View.VISIBLE);
        } else {
            btnFollowing.setVisibility(View.GONE);
            btnFollow.setVisibility(View.VISIBLE);
        }


        btnSettings.setVisibility(View.GONE);
        containerFollow.setClickable(false);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_profileOtherFragment_to_homeFragment);
            }
        });

        profileOtherPageAdapter = new ProfileOtherPageAdapter(getActivity(), getChildFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(profileOtherPageAdapter);
        tabLayout.setupWithViewPager(viewPager);

       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ivProfile.setTransitionName(bundle.getString("transitionName"));
        }*/
        return view;
    }

}
