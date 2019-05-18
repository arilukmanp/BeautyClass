package com.kreasi.beautyclass;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.github.chrisbanes.photoview.PhotoView;
import com.kreasi.beautyclass.Data.CouponData;
import com.kreasi.beautyclass.Data.TransData;
import com.kreasi.beautyclass.Model.CouponModel;
import com.kreasi.beautyclass.Model.TransaksiModel;
import com.kreasi.beautyclass.Presenter.CouponAdapter;
import com.kreasi.beautyclass.Presenter.TransaksiAdapter;
import com.kreasi.beautyclass.View.AgendaTab;
import com.kreasi.beautyclass.View.ContentTemp;
import com.kreasi.beautyclass.View.NewGallery;
import com.kreasi.beautyclass.View.Notes;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageButton transaksi;
    RecyclerView rvTrans;
    private ArrayList<TransaksiModel> listTrans = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        transaksi= findViewById(R.id.transaksi);
        transaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDiaologTrans();
            }
        });
    }

    private void showDiaologTrans() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.transaksi_lyt);
        dialog.setTitle("Transaksi");
        rvTrans = dialog.findViewById(R.id.rv_trans);

        listTrans.addAll(TransData.getTrans());
        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvTrans.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvTrans.setItemAnimator(new DefaultItemAnimator());
        rvTrans.setHasFixedSize(true);
        TransaksiAdapter transaksiAdapter = new TransaksiAdapter(MainActivity.this);

        transaksiAdapter.setListTransaksi(listTrans);
        rvTrans.setAdapter(transaksiAdapter);

        ImageView butCls= dialog.findViewById(R.id.transCLS);
        butCls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
                listTrans.clear();
            }
        });
        dialog.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.rate:
                Toast.makeText(this, "Rate Selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.about:
                Toast.makeText(this, "About Selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void setClick(View view) {

        int id = view.getId();
            Intent moveIntent = new Intent(MainActivity.this, ContentTemp.class);
            moveIntent.putExtra("id", id);
            getApplicationContext().startActivity(moveIntent);

    }

    public void setClickAct(View view) {
        int id = view.getId();
        if (id==R.id.gallery){
            Intent gallery = new Intent(MainActivity.this, NewGallery.class);
            startActivity(gallery);
        }if (id==R.id.schedule){
            Intent agenda = new Intent(MainActivity.this, AgendaTab.class);
            startActivity(agenda);
        }if (id==R.id.notes){
            Intent notes = new Intent(MainActivity.this, Notes.class);
            startActivity(notes);
        }
    }
}
