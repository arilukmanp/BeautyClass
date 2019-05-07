package com.kreasi.beautyclass.View.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kreasi.beautyclass.Data.AgendaData;
import com.kreasi.beautyclass.Model.AgendaModel;
import com.kreasi.beautyclass.Presenter.AgendaVPAdapter;
import com.kreasi.beautyclass.R;
import com.kreasi.beautyclass.View.SpeakerFragment;

import java.util.ArrayList;


public class Day1 extends Fragment {
    ViewPager vpAgenda;
    AgendaVPAdapter adapter;
    ArrayList<AgendaModel> listAgenda= new ArrayList<>();
    TextView title;
    TextView desc;
    TextView speaker;
    String dayChoose;
    private View view;
    CardView card;

    public Day1() {
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
        view = inflater.inflate(R.layout.fragment_day1, container, false);
        listAgenda.addAll(AgendaData.getSchedule("Monday, 12 April 2019"));
        adapter= new AgendaVPAdapter(getContext(),listAgenda);

        vpAgenda = view.findViewById(R.id.AgendaV2);
        vpAgenda.setAdapter(adapter);
        vpAgenda.setPadding(180,0,180,0);

        vpAgenda.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                title= view.findViewById(R.id.titleDescAgendaV2);
                desc = view.findViewById(R.id.DescAgendaV2);
                speaker= view.findViewById(R.id.speakernameV2);
                title.setText(adapter.getListAgenda().get(i).getThemeCourse());
                desc.setText(adapter.getListAgenda().get(i).getDescCourse());
                speaker.setText(adapter.getListAgenda().get(i).getSpeaker());
                View mView=view.findViewById(R.id.backAgenV2);
                if (adapter.getListAgenda().get(i).getStat().equals("1")){
                    mView.setBackgroundColor(getResources().getColor(R.color.pink));
                }else if (adapter.getListAgenda().get(i).getStat().equals("2")){
                    mView.setBackgroundColor(getResources().getColor(R.color.yellow));
                }
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        card = view.findViewById(R.id.spkCardV2);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSpeaker(v);
            }
        });
    }

    public void showSpeaker(View mview) {
        SpeakerFragment speakerFragment = new SpeakerFragment();
        Bundle bundle= new Bundle();
        bundle.putString("key",speaker.getText().toString());
        speakerFragment.setArguments(bundle);
        speakerFragment.show(getActivity().getSupportFragmentManager(),speakerFragment.getTag());
    }

}
