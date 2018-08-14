package com.example.apps.oktaatr.pdam_controlling;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apps.oktaatr.pdam_controlling.Controller.SessionManager;

/**
 * Created by Maorisha Virginia on 16/05/2018.
 */

public class PengaturanFragment extends Fragment {
    TextView btnlokasi, btnwebsite, btnkontak,btncallcenter, btn_logout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_pengaturan, container, false);
        btnlokasi = (TextView) view.findViewById(R.id.btnlokasi);
        btnwebsite = (TextView) view.findViewById(R.id.btnwebsite);
        btnkontak = (TextView) view.findViewById(R.id.btnkontak);
        btncallcenter = (TextView) view.findViewById(R.id.btncallcenter);
        btn_logout = (TextView) view.findViewById(R.id.btn_logout);
        final SessionManager sessionManager = new SessionManager(getContext());
        btnlokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity().getApplication(), LokasiPengaturan.class));
            }
        });
        btnwebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity().getApplication(), WebsitePengaturan.class));
            }
        });
        btnkontak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity().getApplication(), KontakActivity.class));
            }
        });
        btncallcenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity().getApplication(), CallcenterPengaturanActivity.class));
            }
        });
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.logoutUser();
                Intent intent = new Intent(v.getContext(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                getActivity().finish();
            }
        });
        return view;
    }
}
