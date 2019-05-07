package com.kreasi.beautyclass.Presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kreasi.beautyclass.Model.PromoModel;
import com.kreasi.beautyclass.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class PromoAdapter extends RecyclerView.Adapter<PromoAdapter.Holder> {
    public PromoAdapter(Context context) {
        this.context = context;
    }

    private Context context;

    public ArrayList<PromoModel> getListPromo() {
        return listPromo;
    }

    public void setListPromo(ArrayList<PromoModel> listPromo) {
        this.listPromo = listPromo;
    }

    private ArrayList<PromoModel> listPromo;

    @NonNull
    @Override
    public PromoAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemPromo = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.promo_item,viewGroup,false);
        return new Holder(itemPromo);
    }

    @Override
    public void onBindViewHolder(@NonNull PromoAdapter.Holder holder, int i) {
        holder.id.setText(getListPromo().get(i).getIdPromo());
        holder.tvVendor.setText(getListPromo().get(i).getPromoVendor());
        holder.tvDate.setText(getListPromo().get(i).getPromoTime());
        holder.tvTitle.setText(getListPromo().get(i).getPromoTitle());
        Glide.with(context)
                .load(getListPromo().get(i).getPromoPic())
                .apply(new RequestOptions().override(500,500))
                .into(holder.imgPromo);

    }

    @Override
    public int getItemCount() {
        return listPromo.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView imgPromo;
        TextView tvTitle;
        TextView tvDate;
        TextView tvVendor;
        TextView id;

        public Holder(@NonNull View itemView) {
            super(itemView);
            imgPromo=itemView.findViewById(R.id.imgPromo);
            tvTitle=itemView.findViewById(R.id.titlePromo);
            tvDate=itemView.findViewById(R.id.datePromo);
            tvVendor=itemView.findViewById(R.id.vendorPromo);
            id=itemView.findViewById(R.id.idpromo);
        }
    }
}
