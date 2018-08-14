package com.example.apps.oktaatr.pdam_controlling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CallcenterPengaturanActivity extends AppCompatActivity {
    ImageView btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callcenter_pengaturan);
        btnback = (ImageView) findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(CallcenterPengaturanActivity.this, PengaturanFragment.class);
//                finish();
                onBackPressed();
            }
        });
    }
}
