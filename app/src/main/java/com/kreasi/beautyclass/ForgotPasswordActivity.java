package com.kreasi.beautyclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void resetSend(View view){
        EditText emailUser = findViewById(R.id.inputEmail);

        if (TextUtils.isEmpty(emailUser.getText())){
            emailUser.setError("Tidak Boleh Kosong");
        }
    }
}
