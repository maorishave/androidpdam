package com.example.apps.oktaatr.pdam_controlling.Service;

import com.example.apps.oktaatr.pdam_controlling.Model.CountModel;
import com.example.apps.oktaatr.pdam_controlling.Model.DataHasilModel;
import com.example.apps.oktaatr.pdam_controlling.Model.Datainput;
import com.example.apps.oktaatr.pdam_controlling.Model.DetailTugasModel;
import com.example.apps.oktaatr.pdam_controlling.Model.ListBoncModel;
import com.example.apps.oktaatr.pdam_controlling.Model.NotifModel;
import com.example.apps.oktaatr.pdam_controlling.Model.Pemakaianair;
import com.example.apps.oktaatr.pdam_controlling.Model.ProfileModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetService {

    @GET("laravelku/api/bonc-baru/{id}")
    Call<ListBoncModel> getBonc(@Path("id") String id);

    @GET("laravelku/api/bonc-kirim/{id}")
    Call<ListBoncModel> getBoncKirim(@Path("id") String id);

    @GET("laravelku/api/bonc-proses/{id}")
    Call<ListBoncModel> getBoncProses(@Path("id") String id);

    @GET("laravelku/api/count-baru/{id}")
    Call<CountModel> getHitungBaru(@Path("id") String id);

    @GET("laravelku/api/proses-baru/{id}")
    Call<Datainput> getProsesBaru(@Path("id") String id);

    @GET("laravelku/api/bonc-revbaru/{id}")
    Call<ListBoncModel> getBoncRBaru(@Path("id") String id);

    @GET("laravelku/api/bonc-revkirim/{id}")
    Call<ListBoncModel> getBoncRKirim(@Path("id") String id);

    @GET("laravelku/api/bonc-revproses/{id}")
    Call<ListBoncModel> getBoncRProses(@Path("id") String id);

    @GET("laravelku/api/count-revisi/{id}")
    Call<CountModel> getHitungRevisi(@Path("id") String id);

    @GET("laravelku/api/detailbonc/{id}")
    Call<DetailTugasModel> getDetailTugas(@Path("id") String id);

    @GET("laravelku/api/hasil/{id}")
    Call<DataHasilModel> getHasilForm(@Path("id") String id);

    @GET("laravelku/api/profile/{id}")
    Call<ProfileModel> getProfileAkun(@Path("id") String id);

    @GET("laravelku/api/notif-baru/{id}")
    Call<NotifModel> getNotif(@Path("id") String id);
}
