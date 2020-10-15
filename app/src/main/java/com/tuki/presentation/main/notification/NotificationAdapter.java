package com.tuki.presentation.main.notification;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tuki.R;
import com.tuki.data.entity.Notification;
import com.tuki.data.utils.NotificationType;

import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationHolder> {

    private List<Notification> notifications;
    private Context context;

    public NotificationAdapter(List<Notification> notifications) {
        this.notifications = notifications;
    }

    @NonNull
    @Override
    public NotificationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_notification, parent, false);
        return new NotificationHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationHolder holder, int position) {
        Notification notification = notifications.get(position);
        holder.bind(notification);
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }


    public void refresh(List<Notification> notifications) {
        this.notifications.clear();
        this.notifications.addAll(notifications);
        notifyDataSetChanged();
    }


    class NotificationHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.lbl_challenge_route)
        TextView lblChallengeRoute;
        @BindView(R.id.lbl_challenge_status)
        TextView lblChallengeStatus;
        @BindView(R.id.iv_icon)
        ImageView ivIcon;

        @BindView(R.id.iv_background_notification)
        ImageView ivBackgroundNotification;

        @BindString(R.string.challenge_approved)
        String challengeApproved;
        @BindString(R.string.challenge_rejected)
        String challengeRejected;


        NotificationHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(Notification notification) {
            lblChallengeRoute.setText(notification.getMessage());
            Glide.with(itemView)
                    .load(notification.getBackgroundUrl())
                    .into(ivBackgroundNotification);

            if (notification.getType() == NotificationType.CHALLENGE_APPROVED.id) {
                ivIcon.setImageResource(R.drawable.ic_check_mark);
                lblChallengeStatus.setText(challengeApproved);
                lblChallengeStatus.setTextColor(Color.parseColor("#ff99cc00"));

            } else if (notification.getType() == NotificationType.CHALLENGE_REJECTED.id) {
                ivIcon.setImageResource(R.drawable.ic_cross);
                lblChallengeStatus.setText(challengeRejected);
                lblChallengeStatus.setTextColor(Color.parseColor("#ffff4444"));

            } else if (notification.getType() == NotificationType.CHALLENGE_RETRY.id) {
                ivIcon.setImageResource(R.drawable.ic_restore);
                lblChallengeStatus.setVisibility(View.GONE);
                lblChallengeRoute.setGravity(Gravity.START);

            } else {
                throw new EnumConstantNotPresentException(NotificationType.class, "No es un tipo de notificacion");
            }
        }
    }
}
