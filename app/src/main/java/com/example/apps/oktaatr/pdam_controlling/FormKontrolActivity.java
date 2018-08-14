package com.example.apps.oktaatr.pdam_controlling;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.apps.oktaatr.pdam_controlling.Controller.SessionManager;
import com.example.apps.oktaatr.pdam_controlling.Model.Data;
import com.example.apps.oktaatr.pdam_controlling.Model.Datainput;
import com.example.apps.oktaatr.pdam_controlling.Model.InputModel;
import com.example.apps.oktaatr.pdam_controlling.Model.LoginModel;
import com.example.apps.oktaatr.pdam_controlling.Service.Api;
import com.example.apps.oktaatr.pdam_controlling.Service.PostService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.io.DataInput;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormKontrolActivity extends AppCompatActivity {

    ImageView btnback, gambar1,gambar2,gambar3, fotottd;
    ProgressDialog pDialog;
    SessionManager sessionManager;
    TextView no_bon;
    MultipartBody.Part gambarmeter, gambarpersil, gambarpelanggan, gambarttd;
    TextInputEditText stand_meter,tgl_stand_meter, nomor_meter, ukuran, merk_meter, mulai_aliran_air, akhir_aliran_air, total_jam_aliran, guna_persil, jml_jiwa, tlp_plg,  keterangan, kesimpulan;
    private Spinner Spkds_meter, Spkds_air, Spsegel_meter, Spsegel_kopling, Sppipa_phb, Spletak_meter, Spmin_charge, Spplg_pangil, Spsumur, Spsituasi_persil;
    String st_bonc_id, st_stand_meter,st_tgl_stand_meter, st_nomor_meter, st_ukuran, st_merk_meter, st_mulai_aliran_air, st_akhir_aliran_air, st_guna_persil, st_jml_jiwa, st_tlp_plg, st_keterangan, st_kesimpulan, st_Spkds_meter, st_Spkds_air, st_Spsegel_meter, st_Spsegel_kopling, st_Sppipa_phb, st_Spletak_meter, st_Spmin_charge, st_Spplg_pangil, st_Spsumur, st_Spsituasi_persil ;
    RequestBody rb_bonc_id, rb_stand_meter,rb_tgl_stand_meter, rb_nomor_meter, rb_ukuran, rb_merk_meter, rb_mulai_aliran_air, rb_akhir_aliran_air, rb_guna_persil, rb_jml_jiwa, rb_tlp_plg, rb_keterangan, rb_kesimpulan, rb_Spkds_meter, rb_Spkds_air, rb_Spsegel_meter, rb_Spsegel_kopling, rb_Sppipa_phb, rb_Spletak_meter, rb_Spmin_charge, rb_Spplg_pangil, rb_Spsumur, rb_Spsituasi_persil ;
    private Button btnKirim, btnSimpan;
    static Uri capturedImageUri = null;
    static Uri capturedImageUri2 = null;
    static Uri capturedImageUri3 = null;
    static Uri capturedImageUriT = null;
    File file1=null;
    File file2=null;
    File file3=null;
    File file4=null;
    String filename=null;
    String filename2=null;
    String filename3 = null;
    String filenameT = null;
    float scale;
    Bitmap bitmap, bitmap2, bitmap3, bitmapT;
    int w, h;
    Matrix matrix;
    RectF r;

    public static final int TANDATANGAN_ACTIVITY = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_kontrol);
        Bundle bundle=getIntent().getExtras();
        no_bon = (TextView) findViewById(R.id.no_bon);
        stand_meter = (TextInputEditText) findViewById(R.id.stand_meter);
        tgl_stand_meter = (TextInputEditText) findViewById(R.id.tgl_stand_meter);
        nomor_meter = (TextInputEditText) findViewById(R.id.nomor_meter);
        ukuran = (TextInputEditText) findViewById(R.id.ukuran);
        merk_meter = (TextInputEditText) findViewById(R.id.merk_meter);
        mulai_aliran_air = (TextInputEditText) findViewById(R.id.mulai_aliran_air);
        akhir_aliran_air = (TextInputEditText) findViewById(R.id.akhir_aliran_air);
        guna_persil = (TextInputEditText) findViewById(R.id.guna_persil);
        jml_jiwa = (TextInputEditText) findViewById(R.id.jml_jiwa);
        tlp_plg = (TextInputEditText) findViewById(R.id.tlp_plg);
        keterangan = (TextInputEditText) findViewById(R.id.keterangan);
        kesimpulan = (TextInputEditText) findViewById(R.id.kesimpulantl);

        Spkds_meter = (Spinner) findViewById(R.id.kds_meter);
        Spkds_air = (Spinner) findViewById(R.id.kds_air);
        Spsegel_meter = (Spinner) findViewById(R.id.segel_meter);
        Spsegel_kopling = (Spinner) findViewById(R.id.segel_kopling);
        Sppipa_phb = (Spinner) findViewById(R.id.pipa_phb);
        Spletak_meter = (Spinner) findViewById(R.id.letak_meter);
        Spmin_charge = (Spinner) findViewById(R.id.min_charge);
        Spplg_pangil = (Spinner) findViewById(R.id.plg_panggil);
        Spsumur = (Spinner) findViewById(R.id.sumur);
        Spsituasi_persil = (Spinner) findViewById(R.id.situasi_persil);
        gambar1 = (ImageView) findViewById(R.id.gambar1);
        gambar2 = (ImageView) findViewById(R.id.gambar2);
        gambar3 = (ImageView) findViewById(R.id.gambar3);
        fotottd = (ImageView) findViewById(R.id.qrttd);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        isWriteStoragePermissionGranted();
        gambar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TakePicture();
            }
        });

        gambar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TakePicture2();
            }
        });

        gambar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TakePicture3();
            }
        });

        fotottd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormKontrolActivity.this, TandaTanganActivity.class);
                startActivityForResult(intent, TANDATANGAN_ACTIVITY);
            }
        });

        btnback = (ImageView) findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent iAdd = new Intent(FormKontrolActivity.this, TugasBaruActivity.class);
//                startActivity(iAdd);
                onBackPressed();
            }
        });
        String nobonc = bundle.getString("nobonc");
        no_bon.setText(nobonc);
        st_bonc_id = bundle.getString("id");
        btnKirim = (Button) findViewById(R.id.btnKirimForm);
        btnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                st_stand_meter = stand_meter.getText().toString().trim();
                st_tgl_stand_meter = tgl_stand_meter.getText().toString().trim();
                st_nomor_meter = nomor_meter.getText().toString().trim();
                st_ukuran = ukuran.getText().toString().trim();
                st_merk_meter = merk_meter.getText().toString().trim();
                st_Spkds_meter = Spkds_meter.getSelectedItem().toString().trim();
                st_Spkds_air = Spkds_air.getSelectedItem().toString().trim();
                st_mulai_aliran_air = mulai_aliran_air.getText().toString().trim();
                st_akhir_aliran_air = akhir_aliran_air.getText().toString().trim();
                st_Spsegel_meter = Spsegel_meter.getSelectedItem().toString().trim();
                st_Spsegel_kopling = Spsegel_kopling.getSelectedItem().toString().trim();
                st_Sppipa_phb = Sppipa_phb.getSelectedItem().toString().trim();
                st_Spletak_meter = Spletak_meter.getSelectedItem().toString().trim();
                st_Spmin_charge = Spmin_charge.getSelectedItem().toString().trim();
                st_Spplg_pangil = Spplg_pangil.getSelectedItem().toString().trim();
                st_guna_persil = guna_persil.getText().toString().trim();
                st_jml_jiwa = jml_jiwa.getText().toString().trim();
                st_Spsumur = Spsumur.getSelectedItem().toString().trim();
                st_tlp_plg = tlp_plg.getText().toString().trim();
                st_Spsituasi_persil = Spsituasi_persil.getSelectedItem().toString().trim();
                st_keterangan = keterangan.getText().toString().trim();
                st_kesimpulan = kesimpulan.getText().toString().trim();

                if (!st_stand_meter.isEmpty() && !st_tgl_stand_meter.isEmpty()
                        && !st_nomor_meter.isEmpty() && !st_ukuran.isEmpty() && !st_merk_meter.isEmpty()
                        && !st_Spkds_meter.isEmpty() && !st_Spkds_air.isEmpty() && !st_mulai_aliran_air.isEmpty()
                        && !st_akhir_aliran_air.isEmpty() && !st_Spsegel_meter.isEmpty()
                        && !st_Spsegel_kopling.isEmpty() && !st_Sppipa_phb.isEmpty() && !st_Spletak_meter.isEmpty()
                        && !st_Spmin_charge.isEmpty() && !st_Spplg_pangil.isEmpty() && !st_guna_persil.isEmpty()
                        && !st_jml_jiwa.isEmpty() && !st_Spsumur.isEmpty() && !st_tlp_plg.isEmpty() && !st_Spsituasi_persil.isEmpty() ){
                    rb_bonc_id = RequestBody.create(okhttp3.MultipartBody.FORM, st_bonc_id);
                    rb_stand_meter = RequestBody.create(okhttp3.MultipartBody.FORM, st_stand_meter);
                    rb_tgl_stand_meter= RequestBody.create(okhttp3.MultipartBody.FORM, st_tgl_stand_meter);
                    rb_nomor_meter= RequestBody.create(okhttp3.MultipartBody.FORM, st_nomor_meter);
                    rb_ukuran = RequestBody.create(okhttp3.MultipartBody.FORM, st_ukuran);
                    rb_merk_meter = RequestBody.create(okhttp3.MultipartBody.FORM, st_merk_meter);
                    rb_Spkds_meter = RequestBody.create(okhttp3.MultipartBody.FORM, st_Spkds_meter);
                    rb_Spkds_air = RequestBody.create(okhttp3.MultipartBody.FORM, st_Spkds_air);
                    rb_mulai_aliran_air = RequestBody.create(okhttp3.MultipartBody.FORM, st_mulai_aliran_air);
                    rb_akhir_aliran_air = RequestBody.create(okhttp3.MultipartBody.FORM, st_akhir_aliran_air);
                    rb_Spsegel_meter = RequestBody.create(okhttp3.MultipartBody.FORM, st_Spsegel_meter);
                    rb_Spsegel_kopling = RequestBody.create(okhttp3.MultipartBody.FORM, st_Spsegel_kopling);
                    rb_Sppipa_phb = RequestBody.create(okhttp3.MultipartBody.FORM, st_Sppipa_phb);
                    rb_Spletak_meter = RequestBody.create(okhttp3.MultipartBody.FORM, st_Spletak_meter);
                    rb_Spmin_charge = RequestBody.create(okhttp3.MultipartBody.FORM, st_Spmin_charge);
                    rb_Spplg_pangil = RequestBody.create(okhttp3.MultipartBody.FORM, st_Spplg_pangil);
                    rb_guna_persil = RequestBody.create(okhttp3.MultipartBody.FORM, st_guna_persil);
                    rb_jml_jiwa = RequestBody.create(okhttp3.MultipartBody.FORM, st_jml_jiwa);
                    rb_Spsumur = RequestBody.create(okhttp3.MultipartBody.FORM, st_Spsumur);
                    rb_tlp_plg = RequestBody.create(okhttp3.MultipartBody.FORM, st_tlp_plg);
                    rb_keterangan = RequestBody.create(okhttp3.MultipartBody.FORM, st_keterangan);
                    rb_kesimpulan = RequestBody.create(okhttp3.MultipartBody.FORM, st_kesimpulan);
                    rb_Spsituasi_persil = RequestBody.create(okhttp3.MultipartBody.FORM, st_Spsituasi_persil);
//                    doSImpanForm(st_stand_meter, st_tgl_stand_meter, st_nomor_meter, st_ukuran, st_merk_meter,
//                            st_Spkds_meter, st_Spkds_air, st_mulai_aliran_air, st_akhir_aliran_air, st_Spsegel_meter,
//                            st_Spsegel_kopling, st_Sppipa_phb, st_Spletak_meter, st_Spmin_charge,
//                            st_Spplg_pangil, st_guna_persil, st_jml_jiwa, st_Spsumur, st_tlp_plg, st_Spsituasi_persil);
                    pDialog = new ProgressDialog(FormKontrolActivity.this, R.style.Theme_AppCompat_DayNight_Dialog);
                    pDialog.setMessage("Authenticating..");
                    pDialog.show();

                    PostService service = Api.getClient().create(PostService.class);
                    Call<Datainput> call = service.postFormInput(st_bonc_id,rb_stand_meter, rb_tgl_stand_meter, rb_nomor_meter, rb_ukuran, rb_merk_meter,
                            rb_Spkds_meter, rb_Spkds_air, rb_mulai_aliran_air, rb_akhir_aliran_air, rb_Spsegel_meter,
                            rb_Spsegel_kopling, rb_Sppipa_phb, rb_Spletak_meter, rb_Spmin_charge,
                            rb_Spplg_pangil, rb_guna_persil, rb_jml_jiwa, rb_Spsumur, rb_tlp_plg, rb_Spsituasi_persil, rb_keterangan,
                            rb_kesimpulan, rb_bonc_id,
                            gambarmeter, gambarpersil, gambarpelanggan, gambarttd);
                    call.enqueue(new Callback<Datainput>() {
                        @Override
                        public void onResponse(Call<Datainput> call, retrofit2.Response<Datainput> response) {
                            if (response.body().getCode() == 302) {
                                pDialog.dismiss();
                                //Datainput data = response.body().getDatainput();
                                Toast.makeText(FormKontrolActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                //sessionManager.CreateLoginSession(data.getId(),response.body().getCode());
                                Intent dashboard = new Intent(FormKontrolActivity.this, MainActivity.class);
                                startActivity(dashboard);
                            } else {
                                Toast.makeText(FormKontrolActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                pDialog.dismiss();
                            }
                        }

                        @Override
                        public void onFailure(Call<Datainput> call, Throwable t) {
                            Toast.makeText(FormKontrolActivity.this, "Error Bro", Toast.LENGTH_SHORT).show();

                        }
                    });
                }else {
                    Toast.makeText(FormKontrolActivity.this, "data kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnSimpan = (Button) findViewById(R.id.btnSimpanForm);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                st_stand_meter = stand_meter.getText().toString().trim();
                st_tgl_stand_meter = tgl_stand_meter.getText().toString().trim();
                st_nomor_meter = nomor_meter.getText().toString().trim();
                st_ukuran = ukuran.getText().toString().trim();
                st_merk_meter = merk_meter.getText().toString().trim();
                st_Spkds_meter = Spkds_meter.getSelectedItem().toString().trim();
                st_Spkds_air = Spkds_air.getSelectedItem().toString().trim();
                st_mulai_aliran_air = mulai_aliran_air.getText().toString().trim();
                st_akhir_aliran_air = akhir_aliran_air.getText().toString().trim();
                st_Spsegel_meter = Spsegel_meter.getSelectedItem().toString().trim();
                st_Spsegel_kopling = Spsegel_kopling.getSelectedItem().toString().trim();
                st_Sppipa_phb = Sppipa_phb.getSelectedItem().toString().trim();
                st_Spletak_meter = Spletak_meter.getSelectedItem().toString().trim();
                st_Spmin_charge = Spmin_charge.getSelectedItem().toString().trim();
                st_Spplg_pangil = Spplg_pangil.getSelectedItem().toString().trim();
                st_guna_persil = guna_persil.getText().toString().trim();
                st_jml_jiwa = jml_jiwa.getText().toString().trim();
                st_Spsumur = Spsumur.getSelectedItem().toString().trim();
                st_tlp_plg = tlp_plg.getText().toString().trim();
                st_Spsituasi_persil = Spsituasi_persil.getSelectedItem().toString().trim();
                st_keterangan = keterangan.getText().toString().trim();
                st_kesimpulan = kesimpulan.getText().toString().trim();

                if (!st_tgl_stand_meter.isEmpty()) {
                    rb_bonc_id = RequestBody.create(okhttp3.MultipartBody.FORM, st_bonc_id);
                    rb_stand_meter = RequestBody.create(okhttp3.MultipartBody.FORM, st_stand_meter);
                    rb_tgl_stand_meter= RequestBody.create(okhttp3.MultipartBody.FORM, st_tgl_stand_meter);
                    rb_nomor_meter= RequestBody.create(okhttp3.MultipartBody.FORM, st_nomor_meter);
                    rb_ukuran = RequestBody.create(okhttp3.MultipartBody.FORM, st_ukuran);
                    rb_merk_meter = RequestBody.create(okhttp3.MultipartBody.FORM, st_merk_meter);
                    rb_Spkds_meter = RequestBody.create(okhttp3.MultipartBody.FORM, st_Spkds_meter);
                    rb_Spkds_air = RequestBody.create(okhttp3.MultipartBody.FORM, st_Spkds_air);
                    rb_mulai_aliran_air = RequestBody.create(okhttp3.MultipartBody.FORM, st_mulai_aliran_air);
                    rb_akhir_aliran_air = RequestBody.create(okhttp3.MultipartBody.FORM, st_akhir_aliran_air);
                    rb_Spsegel_meter = RequestBody.create(okhttp3.MultipartBody.FORM, st_Spsegel_meter);
                    rb_Spsegel_kopling = RequestBody.create(okhttp3.MultipartBody.FORM, st_Spsegel_kopling);
                    rb_Sppipa_phb = RequestBody.create(okhttp3.MultipartBody.FORM, st_Sppipa_phb);
                    rb_Spletak_meter = RequestBody.create(okhttp3.MultipartBody.FORM, st_Spletak_meter);
                    rb_Spmin_charge = RequestBody.create(okhttp3.MultipartBody.FORM, st_Spmin_charge);
                    rb_Spplg_pangil = RequestBody.create(okhttp3.MultipartBody.FORM, st_Spplg_pangil);
                    rb_guna_persil = RequestBody.create(okhttp3.MultipartBody.FORM, st_guna_persil);
                    rb_jml_jiwa = RequestBody.create(okhttp3.MultipartBody.FORM, st_jml_jiwa);
                    rb_Spsumur = RequestBody.create(okhttp3.MultipartBody.FORM, st_Spsumur);
                    rb_tlp_plg = RequestBody.create(okhttp3.MultipartBody.FORM, st_tlp_plg);
                    rb_keterangan = RequestBody.create(okhttp3.MultipartBody.FORM, st_keterangan);
                    rb_kesimpulan = RequestBody.create(okhttp3.MultipartBody.FORM, st_kesimpulan);
                    rb_Spsituasi_persil = RequestBody.create(okhttp3.MultipartBody.FORM, st_Spsituasi_persil);
//                    doSImpanForm (st_stand_meter, st_tgl_stand_meter, st_nomor_meter, st_ukuran, st_merk_meter,
//                            st_Spkds_meter, st_Spkds_air, st_mulai_aliran_air, st_akhir_aliran_air, st_Spsegel_meter,
//                            st_Spsegel_kopling, st_Sppipa_phb, st_Spletak_meter, st_Spmin_charge,
//                            st_Spplg_pangil, st_guna_persil, st_jml_jiwa, st_Spsumur, st_tlp_plg, st_Spsituasi_persil);
                    pDialog = new ProgressDialog(FormKontrolActivity.this, R.style.Theme_AppCompat_DayNight_Dialog);
                    pDialog.setMessage("Authenticating..");
                    pDialog.show();

                    PostService service = Api.getClient().create(PostService.class);
                    Call<Datainput> call = service.postFormSimpan(st_bonc_id,rb_stand_meter, rb_tgl_stand_meter, rb_nomor_meter, rb_ukuran, rb_merk_meter,
                            rb_Spkds_meter, rb_Spkds_air, rb_mulai_aliran_air, rb_akhir_aliran_air, rb_Spsegel_meter,
                            rb_Spsegel_kopling, rb_Sppipa_phb, rb_Spletak_meter, rb_Spmin_charge,
                            rb_Spplg_pangil, rb_guna_persil, rb_jml_jiwa, rb_Spsumur, rb_tlp_plg, rb_Spsituasi_persil, rb_keterangan,
                            rb_kesimpulan, rb_bonc_id,
                            gambarmeter, gambarpersil, gambarpelanggan, gambarttd);
                    call.enqueue(new Callback<Datainput>() {
                        @Override
                        public void onResponse(Call<Datainput> call, retrofit2.Response<Datainput> response) {
                            if (response.body().getCode() == 302) {
                                pDialog.dismiss();
                                //Datainput data = response.body().getDatainput();
                                Toast.makeText(FormKontrolActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                //sessionManager.CreateLoginSession(data.getId(),response.body().getCode());
                                Intent dashboard = new Intent(FormKontrolActivity.this, MainActivity.class);
                                startActivity(dashboard);
                            } else {
                                Toast.makeText(FormKontrolActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                pDialog.dismiss();
                            }
                        }

                        @Override
                        public void onFailure(Call<Datainput> call, Throwable t) {
                            Toast.makeText(FormKontrolActivity.this, "Error Bro", Toast.LENGTH_SHORT).show();

                        }
                    });
                } else {
                    Toast.makeText(FormKontrolActivity.this, "Masukkan tanggal", Toast.LENGTH_SHORT).show();
                }
            }
            });
        }



    private void TakePicture() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {


            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1001);
            }

        }
        else{
            // Check Camera
            if (this.getPackageManager().hasSystemFeature( PackageManager.FEATURE_CAMERA)) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, capturedImageUri);
                startActivityForResult(cameraIntent, 1888);
            } else {
                Toast.makeText(getApplication(), "Camera not supported", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void TakePicture2() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {


            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1002);
            }

        }
        else{
            // Check Camera
            if (this.getPackageManager().hasSystemFeature( PackageManager.FEATURE_CAMERA)) {
                Intent cameraIntent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                cameraIntent2.putExtra(MediaStore.EXTRA_OUTPUT, capturedImageUri2);
                startActivityForResult(cameraIntent2, 1889);
            } else {
                Toast.makeText(getApplication(), "Camera not supported", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void TakePicture3() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {


            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1003);
            }

        }
        else{
            // Check Camera
            if (this.getPackageManager().hasSystemFeature( PackageManager.FEATURE_CAMERA)) {
                Intent cameraIntent3 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                cameraIntent3.putExtra(MediaStore.EXTRA_OUTPUT, capturedImageUri3);
                startActivityForResult(cameraIntent3, 1890);
            } else {
                Toast.makeText(getApplication(), "Camera not supported", Toast.LENGTH_LONG).show();
            }
        }
    }

    public boolean isWriteStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
//                Log.v(TAG,"Permission is granted2");
                filename = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/Bon Control/meterfile.jpg";
                filename2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/Bon Control/persilfile.jpg";
                filename3 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/Bon Control/pelangganfile.jpg";
                filenameT = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/Bon Control/ttdfile.jpg";

                //Environment.getExternalStorageDirectory().getPath() + "/folder/testfile.jpg";
                capturedImageUri = Uri.fromFile(new File(filename));
                capturedImageUri2 = Uri.fromFile(new File(filename2));
                capturedImageUri3 = Uri.fromFile(new File(filename3));
                capturedImageUriT = Uri.fromFile(new File(filenameT));
                return true;
            } else {

//                Log.v(TAG,"Permission is revoked2");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
//            Log.v(TAG,"Permission is granted2");
            filename = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/Bon Control/meterfile.jpg";
            filename2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/Bon Control/persilfile.jpg";
            filename3 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/Bon Control/pelangganfile.jpg";
            filenameT = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/Bon Control/ttdfile.jpg";
            //Environment.getExternalStorageDirectory().getPath() + "/folder/testfile.jpg";
            capturedImageUri = Uri.fromFile(new File(filename));
            capturedImageUri2 = Uri.fromFile(new File(filename2));
            capturedImageUri3 = Uri.fromFile(new File(filename3));
            capturedImageUriT = Uri.fromFile(new File(filenameT));
            return true;
        }
    }

    private Uri saveImageFile(Bitmap bitmap_data, String filename){
        Uri imageUri = new ImageSaver(getApplicationContext())
                .setFileName(filename)
                .setDirectoryName("Bon Control")
                .setResolution(1024,768)
                .save(bitmap_data);
        return imageUri;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(ActivityCompat.checkSelfPermission(this, permissions[0]) == PackageManager.PERMISSION_GRANTED){
            if(requestCode == 1001) {
                if (this.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, capturedImageUri);
                    startActivityForResult(cameraIntent, 1888);
                } else {
                    Toast.makeText(getApplication(), "Camera not supported", Toast.LENGTH_LONG).show();
                }
            }
            if(requestCode == 1002) {
                if (this.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
                    Intent cameraIntent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    cameraIntent2.putExtra(MediaStore.EXTRA_OUTPUT, capturedImageUri2);
                    startActivityForResult(cameraIntent2, 1889);
                } else {
                    Toast.makeText(getApplication(), "Camera not supported", Toast.LENGTH_LONG).show();
                }
            }
            if(requestCode == 1003) {
                if (this.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
                    Intent cameraIntent3 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    cameraIntent3.putExtra(MediaStore.EXTRA_OUTPUT, capturedImageUri3);
                    startActivityForResult(cameraIntent3, 1890);
                } else {
                    Toast.makeText(getApplication(), "Camera not supported", Toast.LENGTH_LONG).show();
                }
            }


            File folder = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/Bon Control/");
            boolean success = true;
            if (!folder.exists()) {
                Toast.makeText(FormKontrolActivity.this, "Directory Does Not Exist, Create It", Toast.LENGTH_SHORT).show();
                success = folder.mkdir();
            }
            if (success) {
                Toast.makeText(FormKontrolActivity.this, "Directory Created", Toast.LENGTH_SHORT).show();
            } else {
                //Toast.makeText(MainActivity.this, "Failed - Error", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1888) {

            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), capturedImageUri);
            }
            catch (Exception e){
                bitmap = null;
//                Log.e(TAG,"Gagal ambil data gambar");
            }
            Bitmap c= BitmapFactory.decodeFile(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/Bon Control/meterfile.jpg");
            gambar1.setImageBitmap(c);
            saveImageFile(bitmap, "meterfile.jpg");
            file1=new File(capturedImageUri.getPath());
            RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"),file1);

            // MultipartBody.Part is used to send also the actual file name
            gambarmeter = MultipartBody.Part.createFormData("fotometer", file1.getName(), requestFile);
        }

        else if(requestCode==1889) {

            try {
                bitmap2 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), capturedImageUri2);
            }
            catch (Exception e){
                bitmap2 = null;
//                Log.e(TAG,"Gagal ambil data gambar");
            }
            Bitmap d= BitmapFactory.decodeFile(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/Bon Control/persilfile.jpg");
            gambar2.setImageBitmap(d);
            saveImageFile(bitmap2, "persilfile.jpg");
            file2=new File(capturedImageUri2.getPath());
            RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"),file2);

            // MultipartBody.Part is used to send also the actual file name
            gambarpersil = MultipartBody.Part.createFormData("fotopersil", file2.getName(), requestFile);
        }

        else if(requestCode==1890) {

            try {

                bitmap3 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), capturedImageUri3);
            }
            catch (Exception e){
                bitmap3 = null;
//                Log.e(TAG,"Gagal ambil data gambar");
            }
            Bitmap e= BitmapFactory.decodeFile(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/Bon Control/pelangganfile.jpg");
            gambar3.setImageBitmap(e);
            saveImageFile(bitmap3, "pelangganfile.jpg");
            file3=new File(capturedImageUri3.getPath());
            RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"),file3);

            // MultipartBody.Part is used to send also the actual file name
            gambarpelanggan = MultipartBody.Part.createFormData("fotopelanggan", file3.getName(), requestFile);
        }

        else if (requestCode==TANDATANGAN_ACTIVITY){
            try {
                bitmapT = MediaStore.Images.Media.getBitmap(this.getContentResolver(), capturedImageUriT);
            }
            catch (Exception e){
                bitmapT = null;
//                Log.e(TAG,"Gagal ambil data gambar");
            }
            Bitmap f= BitmapFactory.decodeFile(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/Bon Control/ttdfile.jpg");
            fotottd.setImageBitmap(f);
            saveImageFile(bitmapT, "ttdfile.jpg");
            file4=new File(capturedImageUriT.getPath());
            RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"),file4);

            // MultipartBody.Part is used to send also the actual file name
            gambarttd = MultipartBody.Part.createFormData("fotottd", file4.getName(), requestFile);
        }
    }

//    private void doInputFormBaru(final String st_stand_meter, final String st_tgl_stand_meter, final String st_nomor_meter
//            , final String st_ukuran, final String st_merk_meter, final String st_Spkds_meter
//            , final String st_Spkds_air, final String st_mulai_aliran_air, final String st_akhir_aliran_air
//            , final String st_Spsegel_meter, final String st_Spsegel_kopling
//            , final String st_Sppipa_phb, final String st_Spletak_meter, final String st_Spmin_charge
//            , final String st_Spplg_pangil,final String st_guna_persil, final String st_jml_jiwa
//            , final String st_Spsumur, final String st_tlp_plg, final String st_Spsituasi_persil) {
//        pDialog = new ProgressDialog(FormKontrolActivity.this, R.style.Theme_AppCompat_DayNight_Dialog);
//        pDialog.setMessage("Authenticating..");
//        pDialog.show();
//
//        PostService service = Api.getClient().create(PostService.class);
//        Call<Datainput> call = service.postFormInput(st_bonc_id,st_stand_meter, st_tgl_stand_meter, st_nomor_meter, st_ukuran, st_merk_meter,
//                st_Spkds_meter, st_Spkds_air, st_mulai_aliran_air, st_akhir_aliran_air, st_Spsegel_meter,
//                st_Spsegel_kopling, st_Sppipa_phb, st_Spletak_meter, st_Spmin_charge,
//                st_Spplg_pangil, st_guna_persil, st_jml_jiwa, st_Spsumur, st_tlp_plg, st_Spsituasi_persil, st_keterangan, st_kesimpulan, st_bonc_id);
//        call.enqueue(new Callback<Datainput>() {
//            @Override
//            public void onResponse(Call<Datainput> call, retrofit2.Response<Datainput> response) {
//                if (response.body().getCode() == 302) {
//                    pDialog.dismiss();
//                    //Datainput data = response.body().getDatainput();
//                    Toast.makeText(FormKontrolActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                    //sessionManager.CreateLoginSession(data.getId(),response.body().getCode());
//                    Intent dashboard = new Intent(FormKontrolActivity.this, TugasBaruActivity.class);
//                    startActivity(dashboard);
//                } else {
//                    Toast.makeText(FormKontrolActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                    pDialog.dismiss();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Datainput> call, Throwable t) {
//                Toast.makeText(FormKontrolActivity.this, "Error Bro", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//    }

//    private void doSImpanForm (final String st_stand_meter, final String st_tgl_stand_meter, final String st_nomor_meter
//            , final String st_ukuran, final String st_merk_meter, final String st_Spkds_meter
//            , final String st_Spkds_air, final String st_mulai_aliran_air, final String st_akhir_aliran_air
//            , final String st_Spsegel_meter, final String st_Spsegel_kopling
//            , final String st_Sppipa_phb, final String st_Spletak_meter, final String st_Spmin_charge
//            , final String st_Spplg_pangil,final String st_guna_persil, final String st_jml_jiwa
//            , final String st_Spsumur, final String st_tlp_plg, final String st_Spsituasi_persil){
//        pDialog = new ProgressDialog(FormKontrolActivity.this, R.style.Theme_AppCompat_DayNight_Dialog);
//        pDialog.setMessage("Authenticating..");
//        pDialog.show();
//
//        PostService service = Api.getClient().create(PostService.class);
//        Call<Datainput> call = service.postFormSimpan(st_bonc_id,st_stand_meter, st_tgl_stand_meter, st_nomor_meter, st_ukuran, st_merk_meter,
//                st_Spkds_meter, st_Spkds_air, st_mulai_aliran_air, st_akhir_aliran_air, st_Spsegel_meter,
//                st_Spsegel_kopling, st_Sppipa_phb, st_Spletak_meter, st_Spmin_charge,
//                st_Spplg_pangil, st_guna_persil, st_jml_jiwa, st_Spsumur, st_tlp_plg, st_Spsituasi_persil, st_keterangan, st_kesimpulan, st_bonc_id);
//        call.enqueue(new Callback<Datainput>() {
//            @Override
//            public void onResponse(Call<Datainput> call, Response<Datainput> response) {
//                if(response.body().getCode()==302){
//                    pDialog.dismiss();
//                    Toast.makeText(FormKontrolActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                    Intent dashboard = new Intent(FormKontrolActivity.this, MainActivity.class);
//                    startActivity(dashboard);
//                    finish();
//                }
//                else{
//                    Toast.makeText(FormKontrolActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                }
//
//
//            }
//
//            @Override
//            public void onFailure(Call<Datainput> call, Throwable t) {
//                Toast.makeText(FormKontrolActivity.this, "Error bro Simpan Form", Toast.LENGTH_SHORT).show();
//            }
//
//
//        });
//    }
}