package com.kreasi.beautyclass.Presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kreasi.beautyclass.Model.GalleryModel;
import com.kreasi.beautyclass.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GridViewHolder> {
    public GalleryAdapter(Context context) {
        this.context = context;
    }

    private Context context;

    public ArrayList<GalleryModel> getListGaleri() {
        return listGaleri;
    }

    public void setListGaleri(ArrayList<GalleryModel> listGaleri) {
        this.listGaleri = listGaleri;
    }

    private ArrayList<GalleryModel> listGaleri;

    @NonNull
    @Override
    public GalleryAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_gallery,viewGroup,false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryAdapter.GridViewHolder gridViewHolder, int i) {
        Glide.with(context)
                .load(getListGaleri().get(i).getImgUrl())
                .apply(new RequestOptions().override(500,500))
                .into(gridViewHolder.imgGal);
    }

    @Override
    public int getItemCount() {
        return getListGaleri().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgGal;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgGal = itemView.findViewById(R.id.imgGallery);
        }
    }
}
