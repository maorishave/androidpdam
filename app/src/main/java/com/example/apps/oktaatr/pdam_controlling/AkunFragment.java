package com.example.apps.oktaatr.pdam_controlling;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apps.oktaatr.pdam_controlling.Controller.SessionManager;
import com.example.apps.oktaatr.pdam_controlling.Model.DataHasilModel;
import com.example.apps.oktaatr.pdam_controlling.Model.ProfileModel;
import com.example.apps.oktaatr.pdam_controlling.Model.Realisasi;
import com.example.apps.oktaatr.pdam_controlling.Service.Api;
import com.example.apps.oktaatr.pdam_controlling.Service.GetService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Maorisha Virginia on 16/05/2018.
 */

public class AkunFragment extends Fragment {

    TextView teksNama, teksNIP;
    SessionManager manager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_akun, container, false);
        teksNama = (TextView) view.findViewById(R.id.isiNama);
        teksNIP = (TextView) view.findViewById(R.id.isiNIP);

        manager = new SessionManager(getContext());

        getProfile();

        return view;


    }

    private void getProfile() {
        GetService service = Api.getClient().create(GetService.class);
        Call<ProfileModel> call = service.getProfileAkun(manager.getUserDetail().get(SessionManager.KEY_ID));
        call.enqueue(new Callback<ProfileModel>() {
            @Override
            public void onResponse(Call<ProfileModel> call, Response<ProfileModel> response) {
                if (response.body().getCode() == 302){
                    teksNama.setText(response.body().getNama());
                    teksNIP.setText(response.body().getNip());
                    Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ProfileModel> call, Throwable t) {

            }
        });
    }
}
