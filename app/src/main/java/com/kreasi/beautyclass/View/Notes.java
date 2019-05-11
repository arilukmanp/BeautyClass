package com.kreasi.beautyclass.View;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kreasi.beautyclass.R;

import java.util.ArrayList;
import java.util.HashSet;

public class Notes extends AppCompatActivity {
    public static ArrayList<String> notes = new ArrayList<>();
    public static ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        ListView listView = (ListView) findViewById(R.id.list_note);
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.kreasi.beautyclass.View", Context.MODE_PRIVATE);
        HashSet<String> set = (HashSet<String>) sharedPreferences.getStringSet("notes",null);
        if (set==null){
            notes.add("Contoh notes");
        }else {
            notes = new ArrayList<>(set);
        }

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,notes);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), EditorNotes.class);
                intent.putExtra("id",position);
                startActivity(intent);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int item = position;
                new AlertDialog.Builder(Notes.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Apa anda yakin?")
                        .setMessage("Apakah anda yakin ingin menghapus note ini?")
                        .setPositiveButton("Ya,", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                notes.remove(item);
                                adapter.notifyDataSetChanged();
                                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.kreasi.beautyclass.View", Context.MODE_PRIVATE);
                                HashSet<String> set = new HashSet<>(Notes.notes);
                                sharedPreferences.edit().putStringSet("notes",set).apply();
                            }
                        })
                        .setNegativeButton("Tidak",null)
                        .show();
                return true;
            }
        });
        FloatingActionButton fab = findViewById(R.id.add_note);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(getApplicationContext(),EditorNotes.class);
                startActivity(mIntent);
            }
        });
    }
}
