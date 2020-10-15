package com.tuki.presentation.main.profileMe.discounts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tuki.R;
import com.tuki.data.entity.Disscount;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyDisccountsAdapter extends RecyclerView.Adapter<MyDisccountsAdapter.MyDiscountHolder> {

    private List<Disscount> disscounts;
    private OnDisscountItemListener onDisscountItemListener;

    public MyDisccountsAdapter(List<Disscount> disscounts, OnDisscountItemListener onDisscountItemListener) {
        this.disscounts = disscounts;
        this.onDisscountItemListener = onDisscountItemListener;
    }

    @NonNull
    @Override
    public MyDiscountHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_disscount, parent, false);
        return new MyDiscountHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyDiscountHolder holder, int position) {
        Disscount disscount = disscounts.get(position);
        holder.bind(disscount);

    }

    @Override
    public int getItemCount() {
        return disscounts.size();
    }

    public class MyDiscountHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.container_disscount)
        RelativeLayout containerDisscount;

        public MyDiscountHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Disscount disscount) {

            containerDisscount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onDisscountItemListener.onClick(disscount, v, getAdapterPosition(), (short) 1);
                }
            });
        }
    }
}
