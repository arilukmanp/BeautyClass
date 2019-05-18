package com.kreasi.beautyclass.Presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.kreasi.beautyclass.Model.DownloadModel;
import com.kreasi.beautyclass.R;

import java.util.ArrayList;

public class DownloadAdapter extends RecyclerView.Adapter<DownloadAdapter.Holder> {
    private Context context;
    private ArrayList<DownloadModel> listFile;

    public DownloadAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<DownloadModel> getListFile() {
        return listFile;
    }

    public void setListFile(ArrayList<DownloadModel> listFile) {
        this.listFile = listFile;
    }

    @NonNull
    @Override
    public DownloadAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_download,viewGroup,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DownloadAdapter.Holder holder, int i) {
        holder.tvName.setText(listFile.get(i).getNamaDokumen());
        holder.url.setText(listFile.get(i).getUrlDokumen());
        if (listFile.get(i).getStat()== 1){
            Glide.with(context)
                    .load(R.drawable.file)
                    .apply(new RequestOptions().override(500,500))
                    .into(holder.iconFIle);
        }else {
            Glide.with(context)
                    .load(R.drawable.video)
                    .apply(new RequestOptions().override(500,500))
                    .into(holder.iconFIle);
        }

    }

    @Override
    public int getItemCount() {
        return getListFile().size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView url;
        ImageView iconFIle;

        public Holder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.nama_file);
            url = itemView.findViewById(R.id.url_file);
            iconFIle = itemView.findViewById(R.id.icon_file);
        }
    }
}
