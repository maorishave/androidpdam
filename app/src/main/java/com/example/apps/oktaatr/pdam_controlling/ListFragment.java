package com.example.apps.oktaatr.pdam_controlling;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apps.oktaatr.pdam_controlling.Controller.SessionManager;
import com.example.apps.oktaatr.pdam_controlling.Model.CountModel;
import com.example.apps.oktaatr.pdam_controlling.Service.Api;
import com.example.apps.oktaatr.pdam_controlling.Service.GetService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Maorisha Virginia on 16/05/2018.
 */

public class ListFragment extends Fragment {
    CardView CBaru, CProses, CKirim;
    SessionManager manager;
    TextView jmlBaru1, jmlBaru2, jmlBaru3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_list, container, false);
        CBaru = (CardView) view.findViewById(R.id.cardview1baru);
        CProses = (CardView) view.findViewById(R.id.cardview2baru);
        CKirim = (CardView) view.findViewById(R.id.cardview3baru);
        jmlBaru1 = (TextView) view.findViewById(R.id.jumlah_tugasbaru);
        jmlBaru2 = (TextView) view.findViewById(R.id.jumlah2tugasbaru);
        jmlBaru3 = (TextView) view.findViewById(R.id.jumlah3tugasbaru);

        manager = new SessionManager(getContext());
        CBaru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity().getApplication(), TugasBaruActivity.class));

            }

        });
        CProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity().getApplication(), ProsesBaruActivity.class));
            }
        });
        CKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity().getApplication(), KirimBaruActivity.class));
            }
        });

        GetService service= Api.getClient().create(GetService.class);
        Call<CountModel> call=service.getHitungBaru(manager.getUserDetail().get(SessionManager.KEY_ID));
        call.enqueue(new Callback<CountModel>() {
            @Override
            public void onResponse(Call<CountModel> call, Response<CountModel> response) {
                if (response.body().getCode()==302) {
                    jmlBaru1.setText(response.body().getBaru().toString());
                    jmlBaru2.setText(response.body().getProses().toString());
                    jmlBaru3.setText(response.body().getKirim().toString());
                    Toast.makeText(getContext(), response.body().getMessaage(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), response.body().getMessaage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CountModel> call, Throwable t) {

            }
        });
        return view;


    }



}
