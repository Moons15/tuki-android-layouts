package com.tuki.presentation.main.profileMe.discounts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tuki.R;
import com.tuki.data.entity.Disscount;

import java.util.List;

import butterknife.ButterKnife;

public class MyDisscountsAdapter extends RecyclerView.Adapter<MyDisscountsAdapter.MyDisscountHolder> {

    private List<Disscount> disscounts;

    public MyDisscountsAdapter(List<Disscount> disscounts) {
        this.disscounts = disscounts;
    }

    @NonNull
    @Override
    public MyDisscountHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_disscount_small, parent, false);
        return new MyDisscountHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyDisscountHolder holder, int position) {
        Disscount disscount = disscounts.get(position);
        holder.bind(disscount);
    }

    @Override
    public int getItemCount() {
        return disscounts.size();
    }

    public class MyDisscountHolder extends RecyclerView.ViewHolder {


        public MyDisscountHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Disscount disscount) {
        }
    }
}
