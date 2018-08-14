package com.example.apps.oktaatr.pdam_controlling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class WebsitePengaturan extends AppCompatActivity {

    ImageView btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website_pengaturan);
        btnback = (ImageView) findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(WebsitePengaturan.this, PengaturanFragment.class);
//                startActivity(intent);
                onBackPressed();
            }
        });
    }
}