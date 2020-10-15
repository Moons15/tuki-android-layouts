package com.tuki.presentation.main.profileMe.discounts;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;
import com.tuki.R;
import com.tuki.data.entity.Disscount;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DisccountsFragment extends Fragment implements OnDisscountItemListener {

    @BindView(R.id.rv_my_disscounts)
    RecyclerView rvMyDisscounts;
    @BindView(R.id.rv_all_disscounts)
    RecyclerView rvAllDisscounts;

    @BindView(R.id.container_qr_code)
    RelativeLayout containerQrCode;

    private List<Disscount> disscounts = new ArrayList<>();
    private List<Disscount> myDisscounts = new ArrayList<>();

    private AllDisccountsAdapter allDisccountsAdapter;
    private MyDisccountsAdapter myDisccountsAdapter;

    private SnapHelper myDisscountsSnap;
    private SnapHelper allDisccountsSnap;


    public DisccountsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        allDisccountsSnap = new GravitySnapHelper(Gravity.START);
        myDisscountsSnap = new GravitySnapHelper(Gravity.START);

        disscounts.add(new Disscount());
        disscounts.add(new Disscount());
        disscounts.add(new Disscount());

        myDisscounts.add(new Disscount());
        myDisscounts.add(new Disscount());
        myDisscounts.add(new Disscount());
        myDisscounts.add(new Disscount());

        allDisccountsAdapter = new AllDisccountsAdapter(disscounts, this);
        myDisccountsAdapter = new MyDisccountsAdapter(myDisscounts, this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_disccounts, container, false);
        ButterKnife.bind(this, view);

        rvAllDisscounts.setAdapter(allDisccountsAdapter);
        allDisccountsSnap.attachToRecyclerView(rvAllDisscounts);

        rvMyDisscounts.setAdapter(myDisccountsAdapter);
        myDisscountsSnap.attachToRecyclerView(rvMyDisscounts);

        return view;
    }

    @Override
    public void onClick(Disscount disscount, View view, int adapterPosition, short type) {

        containerQrCode.setVisibility(containerQrCode.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
    }
}
