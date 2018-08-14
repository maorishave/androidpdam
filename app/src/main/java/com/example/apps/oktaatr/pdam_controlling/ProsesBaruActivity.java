package com.example.apps.oktaatr.pdam_controlling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apps.oktaatr.pdam_controlling.Controller.SessionManager;
import com.example.apps.oktaatr.pdam_controlling.Model.Bonc;
import com.example.apps.oktaatr.pdam_controlling.Model.ListBoncModel;
import com.example.apps.oktaatr.pdam_controlling.Service.Api;
import com.example.apps.oktaatr.pdam_controlling.Service.GetService;

import com.example.apps.oktaatr.pdam_controlling.Adapter.PBaruAdapter;

import java.util.List;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProsesBaruActivity extends AppCompatActivity {

    private CardView btnform;
    TextView dummy;
    ImageView btnback;
    RecyclerView recyclerView;
    SessionManager sessionManager;
    List<Bonc> boncList;
    PBaruAdapter pBaruAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proses_baru);
        btnback = (ImageView) findViewById(R.id.btnback);
        boncList = new ArrayList<>();
        sessionManager = new SessionManager(getApplicationContext());
        dummy = findViewById(R.id.dummy);
        recyclerView = (RecyclerView) findViewById(R.id.listprosesbaru);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(ProsesBaruActivity.this, ListFragment.class);
//                finish();
                onBackPressed();
            }
        });

        getListBonc();
    }

    private void getListBonc() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        GetService service = Api.getClient().create(GetService.class);
        Call<ListBoncModel> call = service.getBoncProses(sessionManager.getUserDetail().get(SessionManager.KEY_ID));
        call.enqueue(new Callback<ListBoncModel>() {
            @Override
            public void onResponse(Call<ListBoncModel> call, Response<ListBoncModel> response) {
                if(response.body().getCode()==302){
                    boncList = response.body().getBonc();
                    pBaruAdapter= new PBaruAdapter(getApplicationContext(), boncList);
                    recyclerView.setAdapter(pBaruAdapter);

                    Toast.makeText(ProsesBaruActivity.this, response.body().getMessaage(), Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(ProsesBaruActivity.this, response.body().getMessaage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ListBoncModel> call, Throwable t) {
                Toast.makeText(ProsesBaruActivity.this, "error bro", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
