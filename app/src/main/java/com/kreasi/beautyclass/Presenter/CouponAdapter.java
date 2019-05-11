package com.kreasi.beautyclass.Presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kreasi.beautyclass.Model.CouponModel;
import com.kreasi.beautyclass.R;

import java.util.ArrayList;
import java.util.List;

public class CouponAdapter extends RecyclerView.Adapter<CouponAdapter.Holder> {
    private Context context;
    private List<CouponModel> listCoupon = new ArrayList<>();

    public CouponAdapter(Context context) {
        this.context = context;
    }

    public List<CouponModel> getListCoupon() {
        return listCoupon;
    }

    public void setListCoupon(List<CouponModel> listCoupon) {
        this.listCoupon = listCoupon;
    }

    @NonNull
    @Override
    public CouponAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.coupon_item,viewGroup,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CouponAdapter.Holder holder, int i) {
        holder.tvNoCoupon.setText(String.valueOf(listCoupon.get(i).getNoKupon()));
    }

    @Override
    public int getItemCount() {
        return listCoupon.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView tvNoCoupon;
        public Holder(@NonNull View itemView) {
            super(itemView);
            tvNoCoupon = itemView.findViewById(R.id.no_coupon);
        }
    }
}
