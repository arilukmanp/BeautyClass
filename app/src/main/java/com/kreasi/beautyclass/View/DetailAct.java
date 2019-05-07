package com.kreasi.beautyclass.View;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.kreasi.beautyclass.R;

public class DetailAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        frameDetail();

    }

    private void frameDetail() {
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;

        if (bundle.getString("name").equals("Promo")){
            PromoDetail promoDetail = new PromoDetail();
            Bundle mbundel = new Bundle();
            mbundel.putString("ID_PROMO",bundle.getString("id"));
            promoDetail.setArguments(mbundel);
            FragmentManager fragmentManager = getSupportFragmentManager();
            if (fragmentManager != null){
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.frame_detail,promoDetail,PromoDetail.class.getSimpleName());
                ft.addToBackStack(null);
                ft.commit();
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}
