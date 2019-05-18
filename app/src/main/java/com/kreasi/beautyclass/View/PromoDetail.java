package com.kreasi.beautyclass.View;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.kreasi.beautyclass.Data.PromoData;
import com.kreasi.beautyclass.Model.PromoModel;
import com.kreasi.beautyclass.R;

import java.util.ArrayList;

public class PromoDetail extends Fragment {
    String id;
    private ArrayList<PromoModel> listPromo= new ArrayList<>();
    TextView title;
    TextView date;
    TextView desc;
    TextView vendor;
    ImageView img;
    ImageView cls_but;

    public PromoDetail() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_promo_detail, container, false);
        id= getArguments().getString("ID_PROMO");
        listPromo.addAll(PromoData.getPromo());
        int item=0;
        while (item<listPromo.size()){
            if (listPromo.get(item).getIdPromo().equals(id)){
                title=v.findViewById(R.id.name_Promo);
                date=v.findViewById(R.id.date_promo);
                desc=v.findViewById(R.id.desc_promo);
                vendor=v.findViewById(R.id.vendor_detpromo);
                img=v.findViewById(R.id.img_promo);

                title.setText(listPromo.get(item).getPromoTitle());
                date.setText(listPromo.get(item).getPromoTime());
                desc.setText(listPromo.get(item).getPromoDesc());
                vendor.setText(listPromo.get(item).getPromoVendor());
                Glide.with(getContext())
                        .load(listPromo.get(item).getPromoPic())
                        .apply(new RequestOptions().override(500,200))
                        .into(img);
            }
            item++;
            cls_but = v.findViewById(R.id.close_button_promo);
            cls_but.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onDestroyView();
                    getActivity().finish();
                }
            });
        }
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        return super.onCreateAnimation(transit, enter, nextAnim);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
