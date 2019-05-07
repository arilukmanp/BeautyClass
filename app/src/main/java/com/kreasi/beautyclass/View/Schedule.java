package com.kreasi.beautyclass.View;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kreasi.beautyclass.Data.AgendaData;
import com.kreasi.beautyclass.Model.AgendaModel;
import com.kreasi.beautyclass.Presenter.AgendaAdapter;
import com.kreasi.beautyclass.R;

import java.util.ArrayList;

public class Schedule extends Fragment {
    private RecyclerView rvSchedule;
    private ArrayList<AgendaModel> listSchedule = new ArrayList<>();

    public Schedule() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Schedule");
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_schedule, container, false);
        rvSchedule = v.findViewById(R.id.rv_schedule);
        //rvCategory.setHasFixedSize(true);


        listSchedule.addAll(AgendaData.getSchedule("Monday, 12 April 2019"));
        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvSchedule.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvSchedule.setItemAnimator(new DefaultItemAnimator());
        AgendaAdapter scheduleAdapter=new AgendaAdapter(getActivity());

        scheduleAdapter.setListSchedule(listSchedule);
        rvSchedule.setAdapter(scheduleAdapter);

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
