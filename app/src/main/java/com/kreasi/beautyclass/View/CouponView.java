package com.kreasi.beautyclass.View;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kreasi.beautyclass.Data.CouponData;
import com.kreasi.beautyclass.Data.PromoData;
import com.kreasi.beautyclass.Model.CouponModel;
import com.kreasi.beautyclass.Model.PromoModel;
import com.kreasi.beautyclass.Presenter.CouponAdapter;
import com.kreasi.beautyclass.Presenter.PromoAdapter;
import com.kreasi.beautyclass.R;

import java.util.ArrayList;


public class CouponView extends Fragment {
    private RecyclerView rvCoupon;
    private ArrayList<CouponModel> listCoupon = new ArrayList<>();

    public CouponView() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_coupon_view, container, false);
        getActivity().setTitle("Coupon");
        rvCoupon = v.findViewById(R.id.rv_Coupon);

        listCoupon.addAll(CouponData.getKupon());
        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvCoupon.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvCoupon.setItemAnimator(new DefaultItemAnimator());
        rvCoupon.setHasFixedSize(true);
        CouponAdapter couponAdapter = new CouponAdapter(getActivity());

        couponAdapter.setListCoupon(listCoupon);
        rvCoupon.setAdapter(couponAdapter);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
    private void showSelectedItem(CouponModel couponModel) {
        Intent intent = new Intent(getContext(),DetailAct.class);
        intent.putExtra("id",couponModel.getIdKupon());
        intent.putExtra("name","Promo");
        getContext().startActivity(intent);
    }
}
