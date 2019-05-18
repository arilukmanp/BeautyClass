package com.kreasi.beautyclass;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.kreasi.beautyclass.ApiHelper.BaseApiService;
import com.kreasi.beautyclass.ApiHelper.UtilsApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends Activity {
    EditText emailUser;
    EditText passwordUser;
//    Context mContext;
//    BaseApiService mApiService;
//    ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        mContext = this;
//        mApiService = UtilsApi.getAPIService(); // meng-init yang ada di package apihelper
        emailUser = findViewById(R.id.editText3);
        passwordUser = findViewById(R.id.editText2);
    }

    public void loginClick(View view){


        if (TextUtils.isEmpty(emailUser.getText())){
            emailUser.setError("Tidak Boleh Kosong");
        }
        else if (TextUtils.isEmpty(passwordUser.getText())){
            passwordUser.setError("Tidak Boleh Kosong");
        }
        else {
            //loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
            Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(myIntent);
            finish();
        }
    }

    public void forgotPasswordClick(View view){
        Intent myIntent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
        startActivity(myIntent);
    }
//    private void requestLogin(){
//        mApiService.loginRequest(emailUser.getText().toString(), passwordUser.getText().toString())
//                .enqueue(new Callback<ResponseBody>() {
//                    @Override
//                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                        if (response.isSuccessful()){
//                            loading.dismiss();
//                            try {
//                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
//                                if (jsonRESULTS.getString("error").equals("false")){
//                                    // Jika login berhasil maka data nama yang ada di response API
//                                    // akan diparsing ke activity selanjutnya.
//                                    Toast.makeText(mContext, "BERHASIL LOGIN", Toast.LENGTH_SHORT).show();
//                                    String nama = jsonRESULTS.getJSONObject("user").getString("nama");
//                                    Intent intent = new Intent(mContext, MainActivity.class);
//                                    intent.putExtra("result_nama", nama);
//                                    startActivity(intent);
//                                } else {
//                                    // Jika login gagal
//                                    String error_message = jsonRESULTS.getString("error_msg");
//                                    Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
//                                }
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        } else {
//                            loading.dismiss();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseBody> call, Throwable t) {
//                        Log.e("debug", "onFailure: ERROR > " + t.toString());
//                        loading.dismiss();
//                    }
//                });
//    }
}
