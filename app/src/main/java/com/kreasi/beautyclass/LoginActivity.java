package com.kreasi.beautyclass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginClick(View view){
        EditText emailUser = findViewById(R.id.editText3);
        EditText passwordUser = findViewById(R.id.editText2);

        if (TextUtils.isEmpty(emailUser.getText())){
            emailUser.setError("Tidak Boleh Kosong");
        }
        else if (TextUtils.isEmpty(passwordUser.getText())){
            passwordUser.setError("Tidak Boleh Kosong");
        }
        else {
            Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(myIntent);
            finish();
        }
    }

    public void forgotPasswordClick(View view){
        Intent myIntent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
        startActivity(myIntent);
    }
}
