package com.tuki.presentation.main.profileMe.discounts;

import android.view.View;

import com.tuki.data.entity.Challenge;
import com.tuki.data.entity.Disscount;

public interface OnDisscountItemListener {

    void onClick(Disscount disscount, View view, int adapterPosition, short type);
}
