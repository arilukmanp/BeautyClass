package com.kreasi.beautyclass.View;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kreasi.beautyclass.Data.MealsData;
import com.kreasi.beautyclass.Model.MealsModel;
import com.kreasi.beautyclass.Presenter.MealsAdapter;
import com.kreasi.beautyclass.R;

import java.util.ArrayList;

public class Meals extends Fragment {
    private RecyclerView rvMeals;
    private ArrayList<MealsModel> listMeals = new ArrayList<>();

    public Meals() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Meals");
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_meals, container, false);
        rvMeals = v.findViewById(R.id.rv_meals);
        //rvCategory.setHasFixedSize(true);


        listMeals.addAll(MealsData.getMeals());
        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvMeals.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvMeals.setItemAnimator(new DefaultItemAnimator());
        MealsAdapter mealsAdapter = new MealsAdapter(getActivity());

        mealsAdapter.setListMeals(listMeals);
        rvMeals.setAdapter(mealsAdapter);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
