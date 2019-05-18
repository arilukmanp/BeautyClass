package com.kreasi.beautyclass.View;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kreasi.beautyclass.R;

public class Contact extends Fragment {
    private static final int REQUEST_CALL = 1;
    private TextView callNum1;
    private TextView callNum2;
    private String number1;
    private String number2;
    int stat = 0;

    public Contact() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_contact, container, false);
        getActivity().setTitle("Contact");
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView call1 = view.findViewById(R.id.call1);
        ImageView call2 = view.findViewById(R.id.call2);
        callNum1 = view.findViewById(R.id.nomor1);
        callNum2 = view.findViewById(R.id.nomer2);
        number1 = callNum1.getText().toString();
        number2 = callNum2.getText().toString();

        call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stat = 1;
                phoneCall(number1);
            }
        });
        call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stat = 2;
                phoneCall(number2);
            }
        });
    }

    private void phoneCall(String num) {
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CALL);
        }else {
            String dial = "tel:" + num;
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED && stat == 1) {
                phoneCall(number1);
            }if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED && stat == 2) {
                phoneCall(number2);
            }else {
                Toast.makeText(getContext(),"Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
