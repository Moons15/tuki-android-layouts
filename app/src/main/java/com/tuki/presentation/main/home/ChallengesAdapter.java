package com.tuki.presentation.main.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tuki.R;
import com.tuki.data.entity.Challenge;
import com.tuki.data.entity.Route;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChallengesAdapter extends RecyclerView.Adapter<ChallengesAdapter.ChallengeHolder> {

    private List<Challenge> challenges;
    private Context context;
    private OnChallengeItemListener onChallengeItemListener;

    public ChallengesAdapter(List<Challenge> challenges, OnChallengeItemListener onChallengeItemListener) {
        this.challenges = challenges;
        this.onChallengeItemListener = onChallengeItemListener;
    }

    @NonNull
    @Override
    public ChallengeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_route_or_challenge, parent, false);
        return new ChallengeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChallengeHolder holder, int position) {
        Challenge challenge = challenges.get(position);
        holder.bind(challenge);
    }

    @Override
    public int getItemCount() {
        return challenges.size();
    }


    public void refresh(List<Challenge> notifications) {
        this.challenges.clear();
        this.challenges.addAll(notifications);
        notifyDataSetChanged();
    }


    class ChallengeHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.container_route_or_challenge)
        RelativeLayout containerChallenge;
        @BindView(R.id.iv_route_or_challenge)
        ImageView ivChallenge;
        @BindView(R.id.lbl_name_route_or_challenge)
        TextView lblChallengeName;

        public ChallengeHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(Challenge challenge) {
            Glide.with(itemView)
                    .load(challenge.getPhotoUrl())
                    .centerCrop()
                    .into(ivChallenge);

            lblChallengeName.setText(challenge.getName());

            containerChallenge.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onChallengeItemListener.onClick(challenge, v, getAdapterPosition());
                }
            });
        }
    }
}
