package com.kreasi.beautyclass.View;

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
        if (bundle.getInt("id")== R.id.meals){
            Meals meals = new Meals();

            FragmentManager fragmentManager = getSupportFragmentManager();

            if (fragmentManager != null) {

                FragmentTransaction ft = fragmentManager.beginTransaction();

                ft.replace(R.id.frame, meals, Meals.class.getSimpleName());
                ft.addToBackStack(null);

                ft.commit();
            }

        }if (bundle.getInt("id")== R.id.schedule){
            Schedule schedule = new Schedule();

            FragmentManager fragmentManager = getSupportFragmentManager();

            if (fragmentManager != null) {

                FragmentTransaction ft = fragmentManager.beginTransaction();

                ft.replace(R.id.frame, schedule, Schedule.class.getSimpleName());
                ft.addToBackStack(null);

                ft.commit();
            }
        }if (bundle.getInt("id") == R.id.gallery){
            Gallery gallery = new Gallery();

            FragmentManager fragmentManager = getSupportFragmentManager();

            if (fragmentManager != null) {

                FragmentTransaction ft = fragmentManager.beginTransaction();

                ft.replace(R.id.frame, gallery, Gallery.class.getSimpleName());
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
