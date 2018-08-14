package com.example.apps.oktaatr.pdam_controlling.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Detail {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nobonc")
    @Expose
    private String nobonc;
    @SerializedName("tglbonc")
    @Expose
    private String tglbonc;
    @SerializedName("nopel")
    @Expose
    private String nopel;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("sumberdt")
    @Expose
    private String sumberdt;
    @SerializedName("pengaduan")
    @Expose
    private String pengaduan;
    @SerializedName("retribusi")
    @Expose
    private String retribusi;
    @SerializedName("kodetarip")
    @Expose
    private String kodetarip;
    @SerializedName("nopa")
    @Expose
    private Integer nopa;
    @SerializedName("datamtr")
    @Expose
    private String datamtr;
    @SerializedName("masalah")
    @Expose
    private String masalah;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNobonc() {
        return nobonc;
    }

    public void setNobonc(String nobonc) {
        this.nobonc = nobonc;
    }

    public String getTglbonc() {
        return tglbonc;
    }

    public void setTglbonc(String tglbonc) {
        this.tglbonc = tglbonc;
    }

    public String getNopel() {
        return nopel;
    }

    public void setNopel(String nopel) {
        this.nopel = nopel;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getSumberdt() {
        return sumberdt;
    }

    public void setSumberdt(String sumberdt) {
        this.sumberdt = sumberdt;
    }

    public String getPengaduan() {
        return pengaduan;
    }

    public void setPengaduan(String pengaduan) {
        this.pengaduan = pengaduan;
    }

    public String getRetribusi() {
        return retribusi;
    }

    public void setRetribusi(String retribusi) {
        this.retribusi = retribusi;
    }

    public String getKodetarip() {
        return kodetarip;
    }

    public void setKodetarip(String kodetarip) {
        this.kodetarip = kodetarip;
    }

    public Integer getNopa() {
        return nopa;
    }

    public void setNopa(Integer nopa) {
        this.nopa = nopa;
    }

    public String getDatamtr() {
        return datamtr;
    }

    public void setDatamtr(String datamtr) {
        this.datamtr = datamtr;
    }

    public String getMasalah() {
        return masalah;
    }

    public void setMasalah(String masalah) {
        this.masalah = masalah;
    }
}
