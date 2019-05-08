package com.kreasi.beautyclass.Presenter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class SpeakerAdapter extends RecyclerView.Adapter<SpeakerAdapter.Holder> {
    @NonNull
    @Override
    public SpeakerAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SpeakerAdapter.Holder holder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Holder extends RecyclerView.ViewHolder {
        public Holder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
