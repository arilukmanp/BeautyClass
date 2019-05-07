package com.kreasi.beautyclass.View;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.kreasi.beautyclass.R;
import com.kreasi.beautyclass.View.ui.main.Day1;
import com.kreasi.beautyclass.View.ui.main.Day2;
import com.kreasi.beautyclass.View.ui.main.SectionsPagerAdapter;

public class AgendaTab extends AppCompatActivity {
    private SectionsPagerAdapter sectionsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_tab);
        sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        setViewPager(viewPager);
//        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }
    private void setViewPager(ViewPager viewPager){
        SectionsPagerAdapter adapter= new SectionsPagerAdapter(this,getSupportFragmentManager());
        adapter.addFragment(new Day1(),"Day 1");
        adapter.addFragment(new Day2(),"Day 2");
        viewPager.setAdapter(adapter);
    }
}