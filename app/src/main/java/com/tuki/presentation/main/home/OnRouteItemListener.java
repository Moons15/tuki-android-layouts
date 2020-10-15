package com.tuki.presentation.main.home;

import android.view.View;

import com.tuki.data.entity.Contact;
import com.tuki.data.entity.Route;

public interface OnRouteItemListener {

    void onClick(Route route, View view, int adapterPosition);
}
