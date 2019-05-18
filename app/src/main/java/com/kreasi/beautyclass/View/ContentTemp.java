package com.kreasi.beautyclass.View;

import android.provider.ContactsContract;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.kreasi.beautyclass.R;

public class ContentTemp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_temp);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        frameContent();


    }

    private void frameContent() {
        Bundle bundle = getIntent().getExtras();
        if (bundle.getInt("id")== R.id.promo){
            Promo promo = new Promo();

            FragmentManager fragmentManager = getSupportFragmentManager();

            if (fragmentManager != null) {

                FragmentTransaction ft = fragmentManager.beginTransaction();

                ft.replace(R.id.frame, promo, Promo.class.getSimpleName());
                ft.addToBackStack(null);

                ft.commit();
            }

        }if (bundle.getInt("id") == R.id.profil){
            UserProfile userProfile = new UserProfile();

            FragmentManager fragmentManager = getSupportFragmentManager();

            if (fragmentManager != null) {

                FragmentTransaction ft = fragmentManager.beginTransaction();

                ft.replace(R.id.frame, userProfile, UserProfile.class.getSimpleName());
                ft.addToBackStack(null);

                ft.commit();
            }
        }if (bundle.getInt("id") == R.id.qr_code){
            QRcode qRcode = new QRcode();

            FragmentManager fragmentManager = getSupportFragmentManager();

            if (fragmentManager != null) {

                FragmentTransaction ft = fragmentManager.beginTransaction();

                ft.replace(R.id.frame, qRcode, QRcode.class.getSimpleName());
                ft.addToBackStack(null);

                ft.commit();
            }
        }if (bundle.getInt("id") == R.id.coupon){
            CouponView couponView = new CouponView();

            FragmentManager fragmentManager = getSupportFragmentManager();

            if (fragmentManager != null) {

                FragmentTransaction ft = fragmentManager.beginTransaction();

                ft.replace(R.id.frame, couponView, CouponView.class.getSimpleName());
                ft.addToBackStack(null);

                ft.commit();
            }
        }if (bundle.getInt("id") == R.id.contact){
            Contact contact = new Contact();

            FragmentManager fragmentManager = getSupportFragmentManager();

            if (fragmentManager != null) {

                FragmentTransaction ft = fragmentManager.beginTransaction();

                ft.replace(R.id.frame, contact, Contact.class.getSimpleName());
                ft.addToBackStack(null);

                ft.commit();
            }
        }
        if (bundle.getInt("id") == R.id.download){
            DownloadFile downloadFile = new DownloadFile();

            FragmentManager fragmentManager = getSupportFragmentManager();

            if (fragmentManager != null) {

                FragmentTransaction ft = fragmentManager.beginTransaction();

                ft.replace(R.id.frame, downloadFile, DownloadFile.class.getSimpleName());
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
}
