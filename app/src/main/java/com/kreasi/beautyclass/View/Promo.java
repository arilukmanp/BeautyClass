package com.kreasi.beautyclass.View;

import android.content.Intent;
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
import android.widget.ImageView;
import android.widget.TextView;

import com.kreasi.beautyclass.Data.PromoData;
import com.kreasi.beautyclass.ItemClickSupport;
import com.kreasi.beautyclass.Model.PromoModel;
import com.kreasi.beautyclass.Presenter.PromoAdapter;
import com.kreasi.beautyclass.R;

import java.util.ArrayList;

public class Promo extends Fragment {
    private RecyclerView rvPromo;
    private ArrayList<PromoModel> listPromo = new ArrayList<>();
    TextView layer;
    ImageView mark;

    public Promo() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Promo");
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_promo, container, false);
        rvPromo = v.findViewById(R.id.rv_promo);

        listPromo.addAll(PromoData.getPromo());
        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvPromo.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvPromo.setItemAnimator(new DefaultItemAnimator());
        rvPromo.setHasFixedSize(true);
        PromoAdapter promoAdapter = new PromoAdapter(getActivity());

        promoAdapter.setListPromo(listPromo);
        rvPromo.setAdapter(promoAdapter);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ItemClickSupport.addTo(rvPromo).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedItem(listPromo.get(position));
            }
        });
        ItemClickSupport.addTo(rvPromo).setOnItemLongClickListener(new ItemClickSupport.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClicked(RecyclerView recyclerView, int position, View v) {
                layer=v.findViewById(R.id.layPromo);
                layer.setVisibility(v.VISIBLE);
                mark=v.findViewById(R.id.mark);
                mark.setColorFilter(getResources().getColor(R.color.colorPrimary));

                return true;
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void showSelectedItem(PromoModel promoModel) {
        Intent intent = new Intent(getContext(),DetailAct.class);
        intent.putExtra("id",promoModel.getIdPromo());
        intent.putExtra("name","Promo");
        getContext().startActivity(intent);
    }
}
