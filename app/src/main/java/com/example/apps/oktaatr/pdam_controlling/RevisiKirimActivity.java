package com.example.apps.oktaatr.pdam_controlling;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apps.oktaatr.pdam_controlling.Adapter.KRevisiAdapter;
import com.example.apps.oktaatr.pdam_controlling.Controller.SessionManager;
import com.example.apps.oktaatr.pdam_controlling.Model.Bonc;
import com.example.apps.oktaatr.pdam_controlling.Model.ListBoncModel;
import com.example.apps.oktaatr.pdam_controlling.Service.Api;
import com.example.apps.oktaatr.pdam_controlling.Service.GetService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RevisiKirimActivity extends AppCompatActivity {

    ImageView btnback;
    private CardView btnform;
    TextView dummy;
    RecyclerView recyclerView;
    SessionManager sessionManager;
    List<Bonc> boncList;
    KRevisiAdapter kRevisiAdapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revisi_kirim);
        boncList = new ArrayList<>();
        sessionManager = new SessionManager(getApplicationContext());
        dummy = findViewById(R.id.dummy);
        recyclerView = (RecyclerView) findViewById(R.id.listrevisikirim);
        btnback = (ImageView) findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(RevisiKirimActivity.this, RevisiFragment.class);
//                startActivity(intent);
                onBackPressed();
            }
        });
        getListBonc();
    }

    private void getListBonc() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        GetService service = Api.getClient().create(GetService.class);
        Call<ListBoncModel> call = service.getBoncRKirim(sessionManager.getUserDetail().get(SessionManager.KEY_ID));
        call.enqueue(new Callback<ListBoncModel>() {
            @Override
            public void onResponse(Call<ListBoncModel> call, Response<ListBoncModel> response) {
                if (response.body().getCode()==302){
                    boncList = response.body().getBonc();
                    kRevisiAdapter = new KRevisiAdapter(getApplicationContext(), boncList);
                    recyclerView.setAdapter(kRevisiAdapter);
                    Toast.makeText(RevisiKirimActivity.this, response.body().getMessaage(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(RevisiKirimActivity.this, response.body().getMessaage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ListBoncModel> call, Throwable t) {
                //t.printStackTrace();
            }
        });
    }
}
