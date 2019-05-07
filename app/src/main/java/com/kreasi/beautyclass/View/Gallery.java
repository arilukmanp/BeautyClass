package com.kreasi.beautyclass.View;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.github.chrisbanes.photoview.PhotoView;
import com.kreasi.beautyclass.Data.GalleryData;
import com.kreasi.beautyclass.ItemClickSupport;
import com.kreasi.beautyclass.Model.GalleryModel;
import com.kreasi.beautyclass.Presenter.GalleryAdapter;
import com.kreasi.beautyclass.R;

import java.util.ArrayList;


public class Gallery extends Fragment {
    private RecyclerView rvGallery;
    private ArrayList<GalleryModel> listGal = new ArrayList<>();
    GalleryAdapter galleryAdapter;
    ImageView layer;
    private Boolean chooseMode=false;
    ImageButton closeButton;
    ImageView gmb;


    public Gallery() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Promo");
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_gallery, container, false);
        rvGallery = v.findViewById(R.id.rv_gallery);

        listGal.addAll(GalleryData.getImg());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);

        rvGallery.setLayoutManager(gridLayoutManager);
        rvGallery.setHasFixedSize(true);
        galleryAdapter = new GalleryAdapter(getContext());
        galleryAdapter.setListGaleri(listGal);
        rvGallery.setAdapter(galleryAdapter);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ItemClickSupport.addTo(rvGallery).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                layer = v.findViewById(R.id.imgLayer);
                gmb=v.findViewById(R.id.imgGallery);
                if (layer.getVisibility()==v.VISIBLE){
                    layer.setVisibility(v.INVISIBLE);
                }else if (chooseMode==true){
                    layer.setVisibility(v.VISIBLE);
                    layer.setMaxHeight(gmb.getMaxHeight());
                    layer.setMaxWidth(gmb.getMaxWidth());
                }else if (chooseMode == false){
                    showSelectedItem(listGal.get(position));
                }
            }
        });
        ItemClickSupport.addTo(rvGallery).setOnItemLongClickListener(new ItemClickSupport.OnItemLongClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public boolean onItemLongClicked(RecyclerView recyclerView, int position, View v) {

                chooseMode = true;
                layer = v.findViewById(R.id.imgLayer);
                layer.setVisibility(v.VISIBLE);
                getActivity().getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
                getActivity().getActionBar().setDisplayShowCustomEnabled(true);

                getActivity().getActionBar().setCustomView(R.layout.custom_action_bar);


                ColorDrawable colorDrawable = new ColorDrawable(getResources().getColor(R.color.abu));
                getActivity().getActionBar().setBackgroundDrawable(colorDrawable);
                getActivity().getActionBar().setSplitBackgroundDrawable(colorDrawable);

                View mView = getActivity().getActionBar().getCustomView();
                closeButton = (ImageButton) mView.findViewById(R.id.closeBut);
                closeButton.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        onDestroy();
                        startActivity(getActivity().getIntent());
                    }
                });

                return true;
            }
        });
    }
    private void showSelectedItem(GalleryModel galleryModel) {
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.pick_foto);
        dialog.setTitle("Preview Image");
        PhotoView photoView = (PhotoView) dialog.findViewById(R.id.imgPreview);
        //ImageView image = (ImageView) dialog.findViewById(R.id.imgPreview);
        Glide.with(getContext())
                .load(galleryModel.getImgUrl())
                .apply(new RequestOptions().override(500,500))
                .into(photoView);
        TextView downButton = dialog.findViewById(R.id.downloadBtn);
        dialog.show();
    }
}
