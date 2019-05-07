package com.kreasi.beautyclass.View;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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

public class NewGallery extends AppCompatActivity {
    private RecyclerView rvGallery;
    private ArrayList<GalleryModel> listGal = new ArrayList<>();
    GalleryAdapter galleryAdapter;
    ImageView layer;
    private Boolean chooseMode=false;
    ImageButton closeButton;
    ImageView gmb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_gallery);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvGallery = findViewById(R.id.rv_gallery);
        //
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        listGal.addAll(GalleryData.getImg());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);


        rvGallery.setLayoutManager(gridLayoutManager);
        rvGallery.setHasFixedSize(true);
        galleryAdapter = new GalleryAdapter(this);
        galleryAdapter.setListGaleri(listGal);
        rvGallery.setAdapter(galleryAdapter);
        //rvGallery.startAnimation(slide_up);


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
            @Override
            public boolean onItemLongClicked(RecyclerView recyclerView, int position, View v) {

                chooseMode = true;
                layer = v.findViewById(R.id.imgLayer);
                layer.setVisibility(v.VISIBLE);
                getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
                getSupportActionBar().setDisplayShowCustomEnabled(true);

                getSupportActionBar().setCustomView(R.layout.custom_action_bar);


                ColorDrawable colorDrawable = new ColorDrawable(getResources().getColor(R.color.abu));
                getSupportActionBar().setBackgroundDrawable(colorDrawable);
                getSupportActionBar().setSplitBackgroundDrawable(colorDrawable);

                View view = getSupportActionBar().getCustomView();
                closeButton = (ImageButton) view.findViewById(R.id.closeBut);
                closeButton.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        finish();
                        startActivity(getIntent());
                    }
                });


                return true;
            }
        });

    }

    private void showSelectedItem(GalleryModel galleryModel) {

        Dialog dialog = new Dialog(NewGallery.this);
        dialog.setContentView(R.layout.pick_foto);
        dialog.setTitle("Preview Image");
        PhotoView photoView = (PhotoView) dialog.findViewById(R.id.imgPreview);
        //ImageView image = (ImageView) dialog.findViewById(R.id.imgPreview);
        Glide.with(getApplicationContext())
                .load(galleryModel.getImgUrl())
                .apply(new RequestOptions().override(500,500))
                .into(photoView);
        TextView downButton = dialog.findViewById(R.id.downloadBtn);
        dialog.show();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.about){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (chooseMode==true){
            menu.findItem(R.id.about).setVisible(false);
            menu.findItem(R.id.rate).setVisible(false);
        }
        return super.onPrepareOptionsMenu(menu);
    }
}
