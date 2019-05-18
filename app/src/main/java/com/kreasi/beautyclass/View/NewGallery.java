package com.kreasi.beautyclass.View;

import android.Manifest;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.github.chrisbanes.photoview.PhotoView;
import com.kreasi.beautyclass.Data.GalleryData;
import com.kreasi.beautyclass.DownloadFromFile;
import com.kreasi.beautyclass.ItemClickSupport;
import com.kreasi.beautyclass.Model.GalleryModel;
import com.kreasi.beautyclass.Presenter.GalleryAdapter;
import com.kreasi.beautyclass.R;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

public class NewGallery extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {
    private RecyclerView rvGallery;
    private ArrayList<GalleryModel> listGal = new ArrayList<>();
    GalleryAdapter galleryAdapter;
    ImageView layer;
    private Boolean chooseMode=false;
    ImageButton closeButton;
    ImageView gmb;
    private ProgressDialog pDialog;
    private static final int WRITE_REQUEST_CODE = 300;
    private static final String TAG = NewGallery.class.getSimpleName();
    int posGmb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_gallery);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Gallery");

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
                    posGmb = position;
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

    private void showSelectedItem(final GalleryModel galleryModel) {

        final Dialog dialog = new Dialog(NewGallery.this);
        dialog.setContentView(R.layout.pick_foto);
        dialog.setTitle("Preview Image");
        PhotoView photoView = (PhotoView) dialog.findViewById(R.id.imgPreview);
        //ImageView image = (ImageView) dialog.findViewById(R.id.imgPreview);
        Glide.with(getApplicationContext())
                .load(galleryModel.getImgUrl())
                .apply(new RequestOptions().override(500,500))
                .into(photoView);
        TextView downButton = dialog.findViewById(R.id.downloadBtn);
        downButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (EasyPermissions.hasPermissions(NewGallery.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    //Get the URL entered
                    new DownloadFileFromURL().execute(galleryModel.getImgUrl());

                } else {
                    //If permission is not present request for the same.
                    EasyPermissions.requestPermissions(NewGallery.this, getString(R.string.write_file),WRITE_REQUEST_CODE, Manifest.permission.READ_EXTERNAL_STORAGE);
                }
                //new DownloadFileFromURL().execute(galleryModel.getImgUrl());
            }
        });
        ImageView closePrev = dialog.findViewById(R.id.prevImgCLS);
        closePrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
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

    @Override
    protected Dialog onCreateDialog(int id) {
        return super.onCreateDialog(id);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, NewGallery.this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

    }

    class DownloadFileFromURL extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            System.out.println("Starting download");

            pDialog = new ProgressDialog(NewGallery.this);
            pDialog.setMessage("Loading... Please wait...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        /**
         * Downloading file in background thread
         * */
        @Override
        protected String doInBackground(String... f_url) {
            int count;
            try {
                String root = Environment.getExternalStorageDirectory().toString();

                System.out.println("Downloading");
                URL url = new URL(f_url[0]);

                URLConnection conection = url.openConnection();
                conection.connect();
                // getting file length
                int lenghtOfFile = conection.getContentLength();

                // input stream to read file - with 8k buffer
                InputStream input = new BufferedInputStream(url.openStream(), 8192);

                // Output stream to write file

                OutputStream output = new FileOutputStream(root+"/downloaded" + lenghtOfFile + ".jpg");
                byte data[] = new byte[1024];

                long total = 0;
                while ((count = input.read(data)) != -1) {
                    total += count;

                    // writing data to file
                    output.write(data, 0, count);

                }

                // flushing output
                output.flush();

                // closing streams
                output.close();
                input.close();

            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }

            return null;
        }



        /**
         * After completing background task
         * **/
        @Override
        protected void onPostExecute(String file_url) {
            System.out.println("Downloaded");
            Toast.makeText(NewGallery.this,"Download Success",Toast.LENGTH_SHORT).show();
            pDialog.dismiss();
        }

    }
}
