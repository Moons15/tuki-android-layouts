package com.tuki.presentation.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class ViewUtils {

    public static void showContextLabel(Context context, View view, int messsage) {
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int[] location = new int[2];
                v.getLocationOnScreen(location);
                Toast toast = Toast.makeText(context,
                        messsage, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP | Gravity.LEFT, v.getRight(), location[1] + 10);
                toast.show();
                return true;
            }
        });

    }
}
