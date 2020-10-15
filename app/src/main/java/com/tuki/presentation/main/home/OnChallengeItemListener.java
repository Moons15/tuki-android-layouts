package com.tuki.presentation.main.home;

import android.view.View;

import com.tuki.data.entity.Challenge;
import com.tuki.data.entity.Route;

public interface OnChallengeItemListener {

    void onClick(Challenge challenge, View view, int adapterPosition);
}
