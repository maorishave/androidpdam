package com.example.apps.oktaatr.pdam_controlling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.apps.oktaatr.pdam_controlling.Model.DataHasilModel;
import com.example.apps.oktaatr.pdam_controlling.Model.Realisasi;
import com.example.apps.oktaatr.pdam_controlling.Service.Api;
import com.example.apps.oktaatr.pdam_controlling.Service.GetService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormHasilKontrolActivity extends AppCompatActivity {

    ImageView buttonback;
    String id,nobonc;
    Intent intent;
    RecyclerView recyclerView;
    ImageView hsl_fotometer, hsl_fotopersil, hsl_fotopelanggan, hsl_fotottd;
    TextView hsl_standmtr, hsl_tgl, hsl_nometer, hsl_ukuran, hsl_merkmtr, hsl_kondmtr, hsl_kondair, hsl_jamawal, hsl_jamakhir, hsl_sglmtr, hsl_sglkopling, hsl_pipa_phl, hsl_ltkmtr, hsl_mincharge, hsl_pelpersil, hsl_gunapersil, hsl_jumjiwa, hsl_sumur, hsl_telpel, hsl_sitpersil, hsl_ket, hsl_kesim, hsl_ketrev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_hasil_kontrol);
        Bundle bundle = getIntent().getExtras();
        id = bundle.getString("id");
        hsl_standmtr = (TextView) findViewById(R.id.hsl_stdmeter);
        hsl_tgl = (TextView) findViewById(R.id.hsl_tgl);
        hsl_nometer = (TextView) findViewById(R.id.hsl_nometer);
        hsl_ukuran = (TextView) findViewById(R.id.hsl_uk);
        hsl_merkmtr= (TextView) findViewById(R.id.hsl_merk);
        hsl_kondmtr= (TextView) findViewById(R.id.hsl_kond_mtr);
        hsl_kondair = (TextView) findViewById(R.id.hsl_kond_air);
        hsl_jamawal = (TextView) findViewById(R.id.hsl_jamawal);
        hsl_jamakhir = (TextView) findViewById(R.id.hsl_jamakhir);
        hsl_sglmtr = (TextView) findViewById(R.id.hsl_sglmeter);
        hsl_sglkopling = (TextView) findViewById(R.id.hsl_segelkopling);
        hsl_pipa_phl = (TextView) findViewById(R.id.hsl_pipaphlg);
        hsl_ltkmtr= (TextView) findViewById(R.id.hsl_letak_meter);
        hsl_mincharge = (TextView) findViewById(R.id.hsl_mincharge);
        hsl_pelpersil = (TextView) findViewById(R.id.hsl_pelangganpersil);
        hsl_gunapersil = (TextView) findViewById(R.id.hsl_gunapersil);
        hsl_jumjiwa = (TextView) findViewById(R.id.hsl_jumjiwa);
        hsl_sumur = (TextView) findViewById(R.id.hsl_sumur);
        hsl_telpel = (TextView) findViewById(R.id.hsl_telp_plg);
        hsl_sitpersil = (TextView) findViewById(R.id.hsl_situasiprsl);
        hsl_ket = (TextView) findViewById(R.id.hsl_keterangan);
        hsl_kesim = (TextView) findViewById(R.id.hls_kesimpulantl);
        hsl_ketrev = (TextView) findViewById(R.id.hsl_ketrev);
        hsl_fotometer = (ImageView) findViewById(R.id.hsl_fotometer);
        hsl_fotopersil = (ImageView) findViewById(R.id.hsl_fotopersil);
        hsl_fotopelanggan = (ImageView) findViewById(R.id.hsl_fotopelanggan);
        hsl_fotottd = (ImageView) findViewById(R.id.hsl_fotottd);

        buttonback = (ImageView) findViewById(R.id.btnback);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        getHasilForm();
    }

    private void getHasilForm() {
        GetService service = Api.getClient().create(GetService.class);
        Call<DataHasilModel> call = service.getHasilForm(id);
        call.enqueue(new Callback<DataHasilModel>() {
            @Override
            public void onResponse(Call<DataHasilModel> call, Response<DataHasilModel> response) {
                if (response.body().getCode() == 302){
                    Realisasi realisasi = response.body().getRealisasi();
                    hsl_standmtr.setText(realisasi.getStndmtr());
                    hsl_tgl.setText(realisasi.getTglEntry().toString());
                    hsl_nometer.setText(realisasi.getNomtr().toString());
                    hsl_ukuran.setText(realisasi.getUkuranmtr());
                    hsl_merkmtr.setText(realisasi.getMerkmtr());
                    hsl_kondmtr.setText(realisasi.getKondmtr());
                    hsl_kondair.setText(realisasi.getKondair());
                    hsl_jamawal.setText(realisasi.getJammulaiAir());
                    hsl_jamakhir.setText(realisasi.getJamakhirAir());
                    hsl_sglmtr.setText(realisasi.getSglmtr());
                    hsl_sglkopling.setText(realisasi.getSglkopling());
                    hsl_pipa_phl.setText(realisasi.getPipahubung());
                    hsl_ltkmtr.setText(realisasi.getLtkmtr());
                    hsl_mincharge.setText(realisasi.getMincharge());
                    hsl_pelpersil.setText(realisasi.getPelpgl());
                    hsl_gunapersil.setText(realisasi.getGnpersil());
                    hsl_jumjiwa.setText(realisasi.getJumjiwa().toString());
                    hsl_sumur.setText(realisasi.getSumur());
                    hsl_telpel.setText(realisasi.getTelpel());
                    hsl_sitpersil.setText(realisasi.getSitpersil());
                    hsl_ket.setText(realisasi.getKeterangan());
                    hsl_kesim.setText(realisasi.getTindLanjut());
                    hsl_ketrev.setText(realisasi.getKetRealisasi());
                    Glide.with(FormHasilKontrolActivity.this).load(Api.BASE_URL + "/laravelku/public/uploads/foto-realisasi/" + realisasi.getFotometer()).into(hsl_fotometer);
                    Glide.with(FormHasilKontrolActivity.this).load(Api.BASE_URL + "/laravelku/public/uploads/foto-realisasi/" + realisasi.getFotopersil()).into(hsl_fotopersil);
                    Glide.with(FormHasilKontrolActivity.this).load(Api.BASE_URL + "/laravelku/public/uploads/foto-realisasi/" + realisasi.getFotopelanggan()).into(hsl_fotopelanggan);
                    Glide.with(FormHasilKontrolActivity.this).load(Api.BASE_URL + "/laravelku/public/uploads/foto-realisasi/" + realisasi.getFotottd()).into(hsl_fotottd);
                    Toast.makeText(FormHasilKontrolActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(FormHasilKontrolActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<DataHasilModel> call, Throwable t) {
                Toast.makeText(FormHasilKontrolActivity.this, "Error Bro", Toast.LENGTH_SHORT).show();

            }
        });

    }
}