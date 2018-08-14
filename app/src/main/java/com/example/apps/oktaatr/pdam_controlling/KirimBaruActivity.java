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
import com.example.apps.oktaatr.pdam_controlling.Model.DataHasilModel;
import com.example.apps.oktaatr.pdam_controlling.Model.ListBoncModel;
import com.example.apps.oktaatr.pdam_controlling.Model.Realisasi;
import com.example.apps.oktaatr.pdam_controlling.Service.Api;
import com.example.apps.oktaatr.pdam_controlling.Service.GetService;

import com.example.apps.oktaatr.pdam_controlling.Adapter.KBaruAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KirimBaruActivity extends AppCompatActivity {
    private CardView btnform;
    TextView dummy;
    ImageView btnback;
    RecyclerView recyclerView;
    SessionManager sessionManager;
    List<Bonc> boncList;
    KBaruAdapter kBaruAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kirim_baru);
        btnback = (ImageView) findViewById(R.id.btnback);
        boncList = new ArrayList<>();
        sessionManager = new SessionManager(getApplicationContext());
        dummy = findViewById(R.id.dummy);
        recyclerView = (RecyclerView) findViewById(R.id.listkirimbaru);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(KirimBaruActivity.this, ListFragment.class);
//                finish();
                onBackPressed();
            }
        });

        getListBonc();
    }

    private void getListBonc() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        GetService service = Api.getClient().create(GetService.class);
        Call<ListBoncModel> call = service.getBoncKirim(sessionManager.getUserDetail().get(SessionManager.KEY_ID));
        call.enqueue(new Callback<ListBoncModel>() {
            @Override
            public void onResponse(Call<ListBoncModel> call, Response<ListBoncModel> response) {
                if (response.body().getCode()==302){
                    boncList = response.body().getBonc();
                    kBaruAdapter= new KBaruAdapter(getApplicationContext(), boncList);
                    recyclerView.setAdapter(kBaruAdapter);

                    Toast.makeText(KirimBaruActivity.this, response.body().getMessaage(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(KirimBaruActivity.this, response.body().getMessaage(), Toast.LENGTH_SHORT).show();
                }

//                dummy.setText(response.body().message);
//                Toast.makeText(TugasBaruActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                StringBuilder sb = new StringBuilder();
//                List<Bonc> list = response.body().getBoncArrayList();
//
//                for (Bonc bonc : list){
//                    sb.append(bonc.getIdUser() + "\n\n");
//                }
//                dummy.setText(sb.toString());
            }

            @Override
            public void onFailure(Call<ListBoncModel> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}