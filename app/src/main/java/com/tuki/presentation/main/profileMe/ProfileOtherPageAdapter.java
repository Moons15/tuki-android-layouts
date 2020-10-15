package com.tuki.presentation.main.profileMe;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.tuki.R;
import com.tuki.presentation.main.ContactPhotosFragment;
import com.tuki.presentation.main.profileMe.discounts.DisccountsFragment;
import com.tuki.presentation.main.profileMe.myRoutes.MyRoutesFragment;
import com.tuki.presentation.main.profileMe.ranking.RankingFragment;

public class ProfileOtherPageAdapter extends FragmentPagerAdapter {

    private Context context;

    public ProfileOtherPageAdapter(Context context, @NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MyRoutesFragment();
        } else {
            return new ContactPhotosFragment();
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return context.getText(R.string.routes);
        } else {
            return context.getText(R.string.photos);
        }
    }
}
