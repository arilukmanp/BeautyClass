package com.kreasi.beautyclass.View;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.kreasi.beautyclass.R;

import java.util.HashSet;

public class EditorNotes extends AppCompatActivity {
    int idNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor_notes);

        EditText editText = (EditText) findViewById(R.id.edit_notes);
        Intent intent = getIntent();
        idNote=intent.getIntExtra("id",-1);

        if (idNote != -1){
            editText.setText(Notes.notes.get(idNote));
        }else {
            Notes.notes.add("");
            idNote = Notes.notes.size() - 1;
            Notes.adapter.notifyDataSetChanged();
        }
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Notes.notes.set(idNote,String.valueOf(s));
                Notes.adapter.notifyDataSetChanged();

                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.kreasi.beautyclass.View", Context.MODE_PRIVATE);
                HashSet<String> set = new HashSet<>(Notes.notes);
                sharedPreferences.edit().putStringSet("notes",set).apply();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
