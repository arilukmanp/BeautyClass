package com.kreasi.beautyclass.View;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kreasi.beautyclass.Data.CouponData;
import com.kreasi.beautyclass.Data.FileData;
import com.kreasi.beautyclass.ItemClickSupport;
import com.kreasi.beautyclass.Model.CouponModel;
import com.kreasi.beautyclass.Model.DownloadModel;
import com.kreasi.beautyclass.Presenter.CouponAdapter;
import com.kreasi.beautyclass.Presenter.DownloadAdapter;
import com.kreasi.beautyclass.R;

import java.util.ArrayList;
import java.util.HashSet;

public class DownloadFile extends Fragment {
    private RecyclerView rvFile;
    private ArrayList<DownloadModel> listFile = new ArrayList<>();

    public DownloadFile() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_download_file, container, false);
        getActivity().setTitle("Download");
        rvFile = v.findViewById(R.id.rv_file);

        listFile.addAll(FileData.getFile());
        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvFile.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvFile.setItemAnimator(new DefaultItemAnimator());
        rvFile.setHasFixedSize(true);
        rvFile.setItemAnimator(new DefaultItemAnimator());
        DownloadAdapter downloadAdapter = new DownloadAdapter(getActivity());

        downloadAdapter.setListFile(listFile);
        rvFile.setAdapter(downloadAdapter);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ItemClickSupport.addTo(rvFile).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showDialog();
            }
        });
    }
    private void showDialog(){
        new AlertDialog.Builder(getContext())
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Download File")
                .setMessage("Ukuran file 32 MB, apakah ingin lanjut?")
                .setPositiveButton("Ya,", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "Download Gagal", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Tidak",null)
                .show();
    }
}
