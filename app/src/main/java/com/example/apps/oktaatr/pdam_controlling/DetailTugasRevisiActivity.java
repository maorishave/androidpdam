package com.example.apps.oktaatr.pdam_controlling;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apps.oktaatr.pdam_controlling.Adapter.TabelAirAdapter;
import com.example.apps.oktaatr.pdam_controlling.Model.Detail;
import com.example.apps.oktaatr.pdam_controlling.Model.DetailTugasModel;
import com.example.apps.oktaatr.pdam_controlling.Model.Pemakaianair;
import com.example.apps.oktaatr.pdam_controlling.Service.Api;
import com.example.apps.oktaatr.pdam_controlling.Service.GetService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailTugasRevisiActivity extends AppCompatActivity {

    ImageView btnback;
    Button btnisiform;
    String id,nobonc;
    Intent intent;
    RecyclerView recyclerView;
    TextView no_bonc, tgl_bonc, no_pel, nama_pel, alm_pel, sumb_data, asal_peng, retribusi, kode_tarif, no_PA, data_meter, permasalahan;
    List<Pemakaianair> pemakaianairList;
    TabelAirAdapter tabelAirAdapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tugas_revisi);
        Bundle bundle = getIntent().getExtras();
        id = bundle.getString("id");
        nobonc = bundle.getString("nobonc");
        pemakaianairList = new ArrayList<>();
        no_bonc = (TextView) findViewById(R.id.dtr_nobonc);
        tgl_bonc = (TextView) findViewById(R.id.dtr_tgl);
        no_pel = (TextView) findViewById(R.id.dtr_nopel);
        nama_pel = (TextView) findViewById(R.id.dtr_namapel);
        alm_pel = (TextView) findViewById(R.id.dtr_almpel);
        sumb_data = (TextView) findViewById(R.id.dtr_sumber);
        asal_peng = (TextView) findViewById(R.id.dtr_asal_adu);
        retribusi = (TextView) findViewById(R.id.dtr_retribusi);
        kode_tarif = (TextView) findViewById(R.id.dtr_kode_tarif);
        no_PA = (TextView) findViewById(R.id.dtr_no_PA);
        data_meter = (TextView) findViewById(R.id.dtr_data_meter);
        permasalahan = (TextView) findViewById(R.id.dtr_permasalahan);
        btnback = (ImageView) findViewById(R.id.btnback);
        btnisiform = (Button) findViewById(R.id.btnisiform);
        recyclerView = (RecyclerView) findViewById(R.id.listpemakaianair);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(DetailTugasRevisiActivity.this, RevisiBaruActivity.class);
//                startActivity(intent);
                onBackPressed();
            }
        });
        btnisiform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailTugasRevisiActivity.this, FormRevisiActivity.class);
                intent.putExtra("nobonc", nobonc);
                startActivity(intent);
            }
        });
        getDetailTugasR();
    }

    private void getDetailTugasR() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        GetService service = Api.getClient().create(GetService.class);
        Call<DetailTugasModel> call = service.getDetailTugas(id);
        call.enqueue(new Callback<DetailTugasModel>() {
            @Override
            public void onResponse(Call<DetailTugasModel> call, Response<DetailTugasModel> response) {
                if (response.body().getCode() == 302){
                    Detail detail = response.body().getDetail();
                    pemakaianairList = response.body().getPemakaianair();
                    tabelAirAdapter= new TabelAirAdapter(getApplicationContext(), pemakaianairList);
                    recyclerView.setAdapter(tabelAirAdapter);
                    no_bonc.setText(detail.getNobonc().toString());
                    tgl_bonc.setText(detail.getTglbonc().toString());
                    no_pel.setText(detail.getNopel().toString());
                    nama_pel.setText(detail.getNama());
                    alm_pel.setText(detail.getAlamat());
                    sumb_data.setText(detail.getSumberdt());
                    asal_peng.setText(detail.getPengaduan());
                    retribusi.setText(detail.getRetribusi());
                    kode_tarif.setText(detail.getKodetarip());
                    no_PA.setText(detail.getNopa().toString());
                    data_meter.setText(detail.getDatamtr());
                    permasalahan.setText(detail.getMasalah());
                }
            }

            @Override
            public void onFailure(Call<DetailTugasModel> call, Throwable t) {

            }
        });
    }
}
