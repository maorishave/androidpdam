package com.example.apps.oktaatr.pdam_controlling.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataHasilModel {
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("Realisasi")
    @Expose
    private Realisasi realisasi;

//    @SerializedName("RealisasiFoto")
//    @Expose
//    private List<RealisasiFoto> realisasiFoto = null;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Realisasi getRealisasi() {
        return realisasi;
    }

    public void setRealisasi(Realisasi realisasi) {
        this.realisasi = realisasi;
    }

//    public List<RealisasiFoto> getRealisasiFoto() {
//        return realisasiFoto;
//    }
//
//    public void setRealisasiFoto(List<RealisasiFoto> realisasiFoto) {
//        this.realisasiFoto = realisasiFoto;
//    }
}
