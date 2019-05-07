package com.kreasi.beautyclass.View;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kreasi.beautyclass.R;


public class SpeakerFragment extends BottomSheetDialogFragment {
    private View view;
    TextView nmSpk;

    public SpeakerFragment() {
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
        view = inflater.inflate(R.layout.fragment_speaker, container, false);
        String arg = getArguments().getString("key");
        nmSpk = view.findViewById(R.id.name_spk);
        nmSpk.setText(arg);
        return view;
    }


}
