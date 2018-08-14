package com.example.apps.oktaatr.pdam_controlling.Service;

import com.example.apps.oktaatr.pdam_controlling.Model.Datainput;
import com.example.apps.oktaatr.pdam_controlling.Model.InputModel;
import com.example.apps.oktaatr.pdam_controlling.Model.LoginModel;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface PostService {
    @POST("laravelku/api/login")
    @FormUrlEncoded
    Call<LoginModel> postLogin(@Field("nip") String nip, @Field("password") String password);

    @POST("laravelku/api/inputhasil/{id}")
    @Multipart
    Call<Datainput> postFormInput(@Path("id") String id,
                                  @Part("stndmtr") RequestBody stndmtr,
                                  @Part("tgl_entry") RequestBody tgl_entry,
                                  @Part("nomtr") RequestBody nomtr,
                                  @Part("ukuranmtr")RequestBody ukuranmtr,
                                  @Part("merkmtr") RequestBody merkmtr,
                                  @Part("kondmtr") RequestBody kondmtr,
                                  @Part ("kondair") RequestBody kondair,
                                  @Part("jammulai_air") RequestBody jammulai_air,
                                  @Part("jamakhir_air") RequestBody jamakhir_air,
                                  @Part("sglmtr") RequestBody sglmtr,
                                  @Part("sglkopling") RequestBody sglkopling,
                                  @Part("pipahubung") RequestBody pipahubung,
                                  @Part("ltkmtr") RequestBody ltkmtr,
                                  @Part("mincharge") RequestBody mincharge,
                                  @Part("pelpgl") RequestBody pelpgl,
                                  @Part ("gnpersil") RequestBody gnpersil,
                                  @Part("jumjiwa") RequestBody jumjiwa,
                                  @Part("sumur") RequestBody sumur,
                                  @Part("telpel") RequestBody telpel,
                                  @Part("sitpersil") RequestBody sitpersil,
                                  @Part("keterangan") RequestBody keterangan,
                                  @Part("tind_lanjut") RequestBody tind_lanjut,
                                  @Part("bonc_id") RequestBody bonc_id,
                                  @Part MultipartBody.Part fotometer,
                                  @Part MultipartBody.Part fotopersil,
                                  @Part MultipartBody.Part fotopelanggan,
                                  @Part MultipartBody.Part fotottd

                                   );

    @POST("laravelku/api/simpanhasil/{id}")
    @Multipart
    Call<Datainput> postFormSimpan(@Path("id") String id,
                                   @Part("stndmtr") RequestBody stndmtr,
                                   @Part("tgl_entry") RequestBody tgl_entry,
                                   @Part("nomtr") RequestBody nomtr,
                                   @Part("ukuranmtr") RequestBody ukuranmtr,
                                   @Part("merkmtr") RequestBody merkmtr,
                                   @Part("kondmtr") RequestBody kondmtr,
                                   @Part("kondair") RequestBody kondair,
                                   @Part("jammulai_air") RequestBody jammulai_air,
                                   @Part("jamakhir_air") RequestBody jamakhir_air,
                                   @Part("sglmtr") RequestBody sglmtr,
                                   @Part("sglkopling") RequestBody sglkopling,
                                   @Part("pipahubung") RequestBody pipahubung,
                                  @Part("ltkmtr") RequestBody ltkmtr,
                                  @Part("mincharge") RequestBody mincharge,
                                  @Part("pelpgl") RequestBody pelpgl,
                                  @Part("gnpersil") RequestBody gnpersil,
                                  @Part("jumjiwa") RequestBody jumjiwa,
                                  @Part("sumur") RequestBody sumur,
                                  @Part("telpel") RequestBody telpel,
                                  @Part("sitpersil") RequestBody sitpersil,
                                   @Part("keterangan") RequestBody keterangan,
                                   @Part("tind_lanjut") RequestBody tind_lanjut,
                                   @Part("bonc_id") RequestBody bonc_id,
                                   @Part MultipartBody.Part fotometer,
                                   @Part MultipartBody.Part fotopersil,
                                   @Part MultipartBody.Part fotopelanggan,
                                   @Part MultipartBody.Part fotottd
    );

}
