package com.kreasi.beautyclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.kreasi.beautyclass.View.AgendaTab;
import com.kreasi.beautyclass.View.ContentTemp;
import com.kreasi.beautyclass.View.NewGallery;
import com.kreasi.beautyclass.View.Notes;

public class MainActivity extends AppCompatActivity {
    ImageView mealsImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
