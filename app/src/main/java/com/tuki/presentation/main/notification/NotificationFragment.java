package com.tuki.presentation.main.notification;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tuki.R;
import com.tuki.data.entity.Notification;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment {

    @BindView(R.id.rv_notifications)
    RecyclerView rvNotifications;

    private NotificationAdapter notificationAdapter;
    private List<Notification> notifications = new ArrayList<>();

    public NotificationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        notifications.add(new Notification((byte) 1, "Aventura Tumbes", "https://locuraviajes.com/wp-content/uploads/2017/06/mejores-paisajes-mundo-bora-bora-pixabay-600x400.jpg"));
        notifications.add(new Notification((byte) 2, "Aventura Pachacamac", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSdiFDRNjbNS3JC5RvTe7t4pKcebk_aWTgZu46XjzLNgWC-TB8Z"));
        notifications.add(new Notification((byte) 3, "Se ha actualizado la foto del Reto Zorritos", "https://www.paisajesbonitos.org/wp-content/uploads/2016/01/Chichen-Itza-piramide-Templo-de-Kukulc%C3%A1n-mexico-859x447.jpg"));

        notificationAdapter = new NotificationAdapter(notifications);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        ButterKnife.bind(this, view);

        rvNotifications.setAdapter(notificationAdapter);

        return view;
    }


}
