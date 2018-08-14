package com.example.apps.oktaatr.pdam_controlling;

import android.content.Intent;
import android.media.MediaCas;
import android.support.constraint.solver.widgets.WidgetContainer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apps.oktaatr.pdam_controlling.Adapter.TBaruAdapter;
import com.example.apps.oktaatr.pdam_controlling.Controller.SessionManager;
import com.example.apps.oktaatr.pdam_controlling.Model.Bonc;
import com.example.apps.oktaatr.pdam_controlling.Model.ListBoncModel;
import com.example.apps.oktaatr.pdam_controlling.Service.Api;
import com.example.apps.oktaatr.pdam_controlling.Service.GetService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TugasBaruActivity extends AppCompatActivity {

    private CardView btnform;
    TextView dummy;
    ImageView btnback;
    RecyclerView recyclerView;
    SessionManager sessionManager;
    List<Bonc> boncList;
    TBaruAdapter tBaruAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tugas_baru);
        btnback = (ImageView) findViewById(R.id.btnback);
        boncList = new ArrayList<>();
        sessionManager = new SessionManager(getApplicationContext());
        dummy = findViewById(R.id.dummy);
        recyclerView = (RecyclerView) findViewById(R.id.listtugasbaru);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(TugasBaruActivity.this, ListFragment.class);
//                finish();
                onBackPressed();
            }
        });

        getListBonc();
    }

    private void getListBonc() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        GetService service = Api.getClient().create(GetService.class);
        Call<ListBoncModel> call = service.getBonc(sessionManager.getUserDetail().get(SessionManager.KEY_ID));
        call.enqueue(new Callback<ListBoncModel>() {
            @Override
            public void onResponse(Call<ListBoncModel> call, Response<ListBoncModel> response) {
                if (response.body().getCode()==302){
                    boncList = response.body().getBonc();
                    tBaruAdapter= new TBaruAdapter(getApplicationContext(), boncList);
                    recyclerView.setAdapter(tBaruAdapter);
                    Toast.makeText(TugasBaruActivity.this, response.body().getMessaage(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(TugasBaruActivity.this, response.body().getMessaage(), Toast.LENGTH_SHORT).show();
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
                //t.printStackTrace();
            }
        });
    }
}
