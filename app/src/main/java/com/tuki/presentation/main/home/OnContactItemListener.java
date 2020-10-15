package com.tuki.presentation.main.home;

import android.view.View;

import com.tuki.data.entity.Contact;

public interface OnContactItemListener {

    void onClick(Contact contact, View view, int adapterPosition);
}
