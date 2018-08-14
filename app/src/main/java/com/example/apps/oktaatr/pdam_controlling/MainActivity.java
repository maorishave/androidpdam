package com.example.apps.oktaatr.pdam_controlling;

import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.apps.oktaatr.pdam_controlling.Controller.SessionManager;
import com.example.apps.oktaatr.pdam_controlling.Model.DataHasilModel;
import com.example.apps.oktaatr.pdam_controlling.Model.NotifModel;
import com.example.apps.oktaatr.pdam_controlling.Model.Realisasi;
import com.example.apps.oktaatr.pdam_controlling.Service.Api;
import com.example.apps.oktaatr.pdam_controlling.Service.GetService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    SessionManager manager;
    TextView notif1, notif2;
    int countNotif;
    int countNotif2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager=new SessionManager(this);

        overridePendingTransition(R.anim.mytransition, R.anim.mytransition2);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        BottomNavigationViewHelper.disableShiftMode(bottomNav);
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) bottomNav.getChildAt(0);
        View v = menuView.getChildAt(0);
        BottomNavigationItemView itemView = (BottomNavigationItemView) v;
        View notificationBadge = LayoutInflater.from(this).inflate(R.layout.notifikasibaru, menuView, false);
        notif1 = (TextView) notificationBadge.findViewById(R.id.cart_badge);
        notif1.setVisibility(View.GONE);
        itemView.addView(notificationBadge);
        //notif2
        View v2 = menuView.getChildAt(1);
        BottomNavigationItemView itemView2 = (BottomNavigationItemView) v2;
        View notificationBadge2 = LayoutInflater.from(this).inflate(R.layout.notifikasibaru, menuView, false);
        notif2 = (TextView) notificationBadge2.findViewById(R.id.cart_badge);
        notif2.setVisibility(View.GONE);
        itemView2.addView(notificationBadge2);

        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ListFragment()).commit();
        }
        getCountNotif();
        setupBadge();
    }

    private void getCountNotif() {
        GetService service = Api.getClient().create(GetService.class);
        Call<NotifModel> call = service.getNotif("6");
        call.enqueue(new Callback<NotifModel>() {
            @Override
            public void onResponse(Call<NotifModel> call, Response<NotifModel> response) {
                if (response.body().getCode() == 302){
                    countNotif=response.body().getNotifbaru();
                    countNotif2 = response.body().getNotifbaru();
                    if (notif1 != null&&notif2 != null){
                        if (countNotif2 == 0 && countNotif == 0) {
                            if (notif1.getVisibility() == View.GONE && notif2.getVisibility() == View.GONE ){
                                notif1.setVisibility(View.GONE);
                                notif2.setVisibility(View.GONE);
                            }

                        }
                        else if (countNotif2 == 0 || countNotif == 0) {
                            notif2.setText(String.valueOf(Math.min(countNotif2, 99)));
                            if (countNotif == 0){
                                if (notif1.getVisibility() == View.GONE ){
                                    notif1.setVisibility(View.GONE);
                                    notif2.setVisibility(View.VISIBLE);
                                }
                            }
                            else {
                                notif1.setText(String.valueOf(Math.min(countNotif, 99)));
                                if (notif2.getVisibility() == View.GONE ){
                                    notif2.setVisibility(View.GONE);
                                    notif1.setVisibility(View.VISIBLE);

                                }
                            }
                        }
                        else {
                            notif1.setText(String.valueOf(Math.min(countNotif, 99)));
                            notif2.setText(String.valueOf(Math.min(countNotif2, 99)));
                            if (notif2.getVisibility() != View.VISIBLE){
                                notif1.setVisibility(View.VISIBLE);
                                notif2.setVisibility(View.VISIBLE);
                            }
                        }
                    }
                    Toast.makeText(MainActivity.this, "coba", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, response.body().getMessaage(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<NotifModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error Bro", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.menu_list:
                            selectedFragment = new ListFragment();
                            break;
                        case R.id.menu_proses:
                            selectedFragment = new RevisiFragment();
                            break;
                        case R.id.menu_akun:
                            selectedFragment = new AkunFragment();
                            break;
                        case R.id.menu_pengaturan:
                            selectedFragment = new PengaturanFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                    return true;
                }
            };

    private void setupBadge(){

//        else if (notif1 != null){
//            if (countNotif == 0 ) {
//                if (notif1.getVisibility() != View.GONE){
//                    notif1.setVisibility(View.GONE);
//                }
//            }else {
//                notif1.setText(String.valueOf(Math.min(countNotif, 99)));
//                if (notif1.getVisibility() != View.VISIBLE){
//                    notif1.setVisibility(View.VISIBLE);
//                }
//            }
//        }
//
//        if (notif2 != null){
//            if (countNotif == 0) {
//                if (notif1.getVisibility() != View.GONE){
//                    notif1.setVisibility(View.GONE);
//                }
//            }else {
//                notif1.setText(String.valueOf(Math.min(countNotif, 99)));
//                if (notif1.getVisibility() != View.VISIBLE){
//                    notif1.setVisibility(View.VISIBLE);
//                }
//            }
//        }
    }
    }

