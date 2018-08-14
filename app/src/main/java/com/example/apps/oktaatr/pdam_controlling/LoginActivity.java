package com.example.apps.oktaatr.pdam_controlling;

import android.app.ProgressDialog;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.apps.oktaatr.pdam_controlling.Controller.SessionManager;
import com.example.apps.oktaatr.pdam_controlling.Model.Data;
import com.example.apps.oktaatr.pdam_controlling.Model.LoginModel;
import com.example.apps.oktaatr.pdam_controlling.Service.Api;
import com.example.apps.oktaatr.pdam_controlling.Service.ApiService;
import com.example.apps.oktaatr.pdam_controlling.Service.PostService;

import retrofit2.Call;
import retrofit2.Callback;

public class LoginActivity extends AppCompatActivity {
    private static long back_pressed;
    private Button btn_login;
    String snip, spassword;
    ProgressDialog pDialog;
    TextInputEditText et_nip, et_password;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        overridePendingTransition(R.anim.mytransition, R.anim.mytransition2);

        et_nip = (TextInputEditText) findViewById(R.id.txt_nip);
        et_password = (TextInputEditText) findViewById(R.id.txt_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        sessionManager = new SessionManager(getApplicationContext());

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO LOGIN
                snip = et_nip.getText().toString().trim();
                spassword = et_password.getText().toString().trim();
                if (!snip.isEmpty() && !spassword.isEmpty()) {
                    doLogin(snip, spassword);
                } else {
                    Toast.makeText(LoginActivity.this, "data kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void doLogin(final String snip, final String spassword) {
        pDialog = new ProgressDialog(LoginActivity.this, R.style.Theme_AppCompat_DayNight_Dialog);
        pDialog.setMessage("Authenticating..");
        pDialog.show();

        PostService service = Api.getClient().create(PostService.class);
        Call<LoginModel> call = service.postLogin(snip,spassword);
        call.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, retrofit2.Response<LoginModel> response) {
                if (response.body().getCode()==302) {
                    pDialog.dismiss();
                    Data data = response.body().getData();
                    //Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    sessionManager.CreateLoginSession(data.getId(),response.body().getCode());
                    Intent dashboard = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(dashboard);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    pDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {

            }
        });
    }
}