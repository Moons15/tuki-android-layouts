package com.tuki.presentation.main.profileMe;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.tuki.R;
import com.tuki.presentation.main.profileMe.discounts.DisccountsFragment;
import com.tuki.presentation.main.profileMe.myRoutes.MyRoutesFragment;
import com.tuki.presentation.main.profileMe.ranking.RankingFragment;

public class ProfileMePageAdapter extends FragmentPagerAdapter {

    private Context context;

    public ProfileMePageAdapter(Context context, @NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MyRoutesFragment();
        } else if (position == 1) {
            return new DisccountsFragment();
        } else {
            return new RankingFragment();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return context.getText(R.string.my_routes);
        } else if (position == 1) {
            return context.getText(R.string.disscounts);
        } else {
            return context.getText(R.string.ranking);
        }
    }
}
