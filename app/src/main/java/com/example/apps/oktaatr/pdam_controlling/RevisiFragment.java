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

public class RevisiFragment extends Fragment {
    CardView RBaru, RProses, RKirim;
    SessionManager manager;
    TextView jmlRevisi1, jmlRevisi2, jmlRevisi3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_revisi, container, false);
        RBaru = (CardView) view.findViewById(R.id.cardviewrevisi1baru);
        RProses = (CardView) view.findViewById(R.id.cardviewrevisi2baru);
        RKirim = (CardView) view.findViewById(R.id.cardviewrevisi3baru);
        jmlRevisi1 = (TextView) view.findViewById(R.id.jumlah_tugasrevisi);
        jmlRevisi2 = (TextView) view.findViewById(R.id.jumlah2tugasrevisi);
        jmlRevisi3 = (TextView) view.findViewById(R.id.jumlah3tugasrevisi);

        manager = new SessionManager(getContext());


        RBaru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity().getApplication(), RevisiBaruActivity.class));
            }
        });
        RProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity().getApplication(), RevisiProsesActivity.class));
            }
        });
        RKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity().getApplication(), RevisiKirimActivity.class));
            }
        });

        GetService service = Api.getClient().create(GetService.class);
        Call<CountModel> call = service.getHitungRevisi(manager.getUserDetail().get(SessionManager.KEY_ID));
        call.enqueue(new Callback<CountModel>() {
            @Override
            public void onResponse(retrofit2.Call<CountModel> call, Response<CountModel> response) {
                if (response.body().getCode()==302) {
                    jmlRevisi1.setText(response.body().getBaru().toString());
                    jmlRevisi2.setText(response.body().getProses().toString());
                    jmlRevisi3.setText(response.body().getKirim().toString());
                    Toast.makeText(getContext(), response.body().getMessaage(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), response.body().getMessaage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<CountModel> call, Throwable t) {

            }
        });

        return view;
    }
}
