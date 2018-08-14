package com.example.apps.oktaatr.pdam_controlling.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Bonc {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nomerbon")
    @Expose
    private String nomerbon;
    @SerializedName("tglbon")
    @Expose
    private String tglbon;
    @SerializedName("namapel")
    @Expose
    private String namapel;
    @SerializedName("nopel")
    @Expose
    private String nopel;
    @SerializedName("alamatpel")
    @Expose
    private String alamatpel;
    @SerializedName("masalah")
    @Expose
    private String masalah;
    @SerializedName("ket_realisasi")
    @Expose
    private String ket_realisasi;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomerbon() {
        return nomerbon;
    }

    public void setNomerbon(String nomerbon) {
        this.nomerbon = nomerbon;
    }

    public String getTglbon() {
        return tglbon;
    }

    public void setTglbon(String tglbon) {
        this.tglbon = tglbon;
    }

    public String getNamapel() {
        return namapel;
    }

    public void setNamapel(String namapel) {
        this.namapel = namapel;
    }

    public String getNopel() {
        return nopel;
    }

    public void setNopel(String nopel) {
        this.nopel = nopel;
    }

    public String getAlamatpel() {
        return alamatpel;
    }

    public void setAlamatpel(String alamatpel) {
        this.alamatpel = alamatpel;
    }

    public String getMasalah() {
        return masalah;
    }

    public void setMasalah(String masalah) {
        this.masalah = masalah;
    }

    public String getKet_realisasi() {
        return ket_realisasi;
    }
    public void setKet_realisasi(String ket_realisasi) {
        this.ket_realisasi = ket_realisasi;
    }

}
