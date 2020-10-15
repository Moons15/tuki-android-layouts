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
import com.tuki.data.entity.Route;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LastRoutesAdapter extends RecyclerView.Adapter<LastRoutesAdapter.RouteHolder> {

    private List<Route> routes;
    private Context context;
    private OnRouteItemListener onRouteItemListener;

    public LastRoutesAdapter(List<Route> route, OnRouteItemListener onRouteItemListener) {
        this.routes = route;
        this.onRouteItemListener = onRouteItemListener;
    }

    @NonNull
    @Override
    public RouteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_route_or_challenge, parent, false);
        return new RouteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RouteHolder holder, int position) {
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


    class RouteHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.container_route_or_challenge)
        RelativeLayout containerRoute;
        @BindView(R.id.iv_route_or_challenge)
        ImageView ivRoute;
        @BindView(R.id.lbl_name_route_or_challenge)
        TextView lblRoutePlace;

        public RouteHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(Route route) {
            Glide.with(itemView)
                    .load(route.getPhotoUrl())
                    .centerCrop()
                    .into(ivRoute);

            lblRoutePlace.setText(route.getName());

            containerRoute.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onRouteItemListener.onClick(route, v, getAdapterPosition());
                }
            });
        }
    }
}
