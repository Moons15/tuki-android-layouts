package com.tuki.presentation.main.home;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.bumptech.glide.Glide;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;
import com.tuki.R;
import com.tuki.data.entity.Route;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChallengesByRouteAdapter extends RecyclerView.Adapter<ChallengesByRouteAdapter.ChallengeByRouteHolder> {

    private List<Route> routes;
    private Context context;
    private OnChallengeItemListener onChallengeItemListener;


    public ChallengesByRouteAdapter(List<Route> routes, OnChallengeItemListener onChallengeItemListener) {
        this.routes = routes;
        this.onChallengeItemListener = onChallengeItemListener;
    }

    @NonNull
    @Override
    public ChallengeByRouteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_route_and_challenges, parent, false);
        return new ChallengeByRouteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChallengeByRouteHolder holder, int position) {
        Route route = routes.get(position);
        holder.bind(route);
    }

    @Override
    public int getItemCount() {
        return routes.size();
    }


    public void refresh(List<Route> notifications) {
        this.routes.clear();
        this.routes.addAll(notifications);
        notifyDataSetChanged();
    }


    class ChallengeByRouteHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.rv_challenges_by_route)
        RecyclerView rvChallengesByRoute;
        @BindView(R.id.lbl_route_name)
        TextView lblRouteName;

        public ChallengeByRouteHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(Route route) {
            lblRouteName.setText(route.getName());
            rvChallengesByRoute.setAdapter(new ChallengesAdapter(route.getChallenges(), onChallengeItemListener));
            rvChallengesByRoute.setHasFixedSize(true);
            rvChallengesByRoute.setNestedScrollingEnabled(false);
            new GravitySnapHelper(Gravity.START).attachToRecyclerView(rvChallengesByRoute);

        }
    }
}
