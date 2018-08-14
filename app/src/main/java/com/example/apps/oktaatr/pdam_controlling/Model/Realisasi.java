package com.example.apps.oktaatr.pdam_controlling.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Realisasi {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("tgl_entry")
    @Expose
    private String tglEntry;
    @SerializedName("stndmtr")
    @Expose
    private String stndmtr;
    @SerializedName("nomtr")
    @Expose
    private String nomtr;
    @SerializedName("ukuranmtr")
    @Expose
    private String ukuranmtr;
    @SerializedName("merkmtr")
    @Expose
    private String merkmtr;
    @SerializedName("kondmtr")
    @Expose
    private String kondmtr;
    @SerializedName("kondair")
    @Expose
    private String kondair;
    @SerializedName("jammulai_air")
    @Expose
    private String jammulaiAir;
    @SerializedName("jamakhir_air")
    @Expose
    private String jamakhirAir;
    @SerializedName("sglmtr")
    @Expose
    private String sglmtr;
    @SerializedName("sglkopling")
    @Expose
    private String sglkopling;
    @SerializedName("pipahubung")
    @Expose
    private String pipahubung;
    @SerializedName("ltkmtr")
    @Expose
    private String ltkmtr;
    @SerializedName("mincharge")
    @Expose
    private String mincharge;
    @SerializedName("pelpgl")
    @Expose
    private String pelpgl;
    @SerializedName("gnpersil")
    @Expose
    private String gnpersil;
    @SerializedName("jumjiwa")
    @Expose
    private String jumjiwa;
    @SerializedName("sumur")
    @Expose
    private String sumur;
    @SerializedName("telpel")
    @Expose
    private String telpel;
    @SerializedName("sitpersil")
    @Expose
    private String sitpersil;
    @SerializedName("tgl_realisasi")
    @Expose
    private String tglRealisasi;
    @SerializedName("keterangan")
    @Expose
    private String keterangan;
    @SerializedName("tind_lanjut")
    @Expose
    private String tindLanjut;
    @SerializedName("bonc_id")
    @Expose
    private Integer boncId;
    @SerializedName("status_baru")
    @Expose
    private Integer statusBaru;
    @SerializedName("status_revisi")
    @Expose
    private Integer statusRevisi;
    @SerializedName("ket_realisasi")
    @Expose
    private String ketRealisasi;
    @SerializedName("fotometer")
    @Expose
    private String fotometer;
    @SerializedName("fotopersil")
    @Expose
    private String fotopersil;
    @SerializedName("fotopelanggan")
    @Expose
    private String fotopelanggan;
    @SerializedName("fotottd")
    @Expose
    private String fotottd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTglEntry() {
        return tglEntry;
    }

    public void setTglEntry(String tglEntry) {
        this.tglEntry = tglEntry;
    }

    public String getStndmtr() {
        return stndmtr;
    }

    public void setStndmtr(String stndmtr) {
        this.stndmtr = stndmtr;
    }

    public String getNomtr() {
        return nomtr;
    }

    public void setNomtr(String nomtr) {
        this.nomtr = nomtr;
    }

    public String getUkuranmtr() {
        return ukuranmtr;
    }

    public void setUkuranmtr(String ukuranmtr) {
        this.ukuranmtr = ukuranmtr;
    }

    public String getMerkmtr() {
        return merkmtr;
    }

    public void setMerkmtr(String merkmtr) {
        this.merkmtr = merkmtr;
    }

    public String getKondmtr() {
        return kondmtr;
    }

    public void setKondmtr(String kondmtr) {
        this.kondmtr = kondmtr;
    }

    public String getKondair() {
        return kondair;
    }

    public void setKondair(String kondair) {
        this.kondair = kondair;
    }

    public String getJammulaiAir() {
        return jammulaiAir;
    }

    public void setJammulaiAir(String jammulaiAir) {
        this.jammulaiAir = jammulaiAir;
    }

    public String getJamakhirAir() {
        return jamakhirAir;
    }

    public void setJamakhirAir(String jamakhirAir) {
        this.jamakhirAir = jamakhirAir;
    }

    public String getSglmtr() {
        return sglmtr;
    }

    public void setSglmtr(String sglmtr) {
        this.sglmtr = sglmtr;
    }

    public String getSglkopling() {
        return sglkopling;
    }

    public void setSglkopling(String sglkopling) {
        this.sglkopling = sglkopling;
    }

    public String getPipahubung() {
        return pipahubung;
    }

    public void setPipahubung(String pipahubung) {
        this.pipahubung = pipahubung;
    }

    public String getLtkmtr() {
        return ltkmtr;
    }

    public void setLtkmtr(String ltkmtr) {
        this.ltkmtr = ltkmtr;
    }

    public String getMincharge() {
        return mincharge;
    }

    public void setMincharge(String mincharge) {
        this.mincharge = mincharge;
    }

    public String getPelpgl() {
        return pelpgl;
    }

    public void setPelpgl(String pelpgl) {
        this.pelpgl = pelpgl;
    }

    public String getGnpersil() {
        return gnpersil;
    }

    public void setGnpersil(String gnpersil) {
        this.gnpersil = gnpersil;
    }

    public String getJumjiwa() {
        return jumjiwa;
    }

    public void setJumjiwa(String jumjiwa) {
        this.jumjiwa = jumjiwa;
    }

    public String getSumur() {
        return sumur;
    }

    public void setSumur(String sumur) {
        this.sumur = sumur;
    }

    public String getTelpel() {
        return telpel;
    }

    public void setTelpel(String telpel) {
        this.telpel = telpel;
    }

    public String getSitpersil() {
        return sitpersil;
    }

    public void setSitpersil(String sitpersil) {
        this.sitpersil = sitpersil;
    }

    public String getTglRealisasi() {
        return tglRealisasi;
    }

    public void setTglRealisasi(String tglRealisasi) {
        this.tglRealisasi = tglRealisasi;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getTindLanjut() {
        return tindLanjut;
    }

    public void setTindLanjut(String tindLanjut) {
        this.tindLanjut = tindLanjut;
    }

    public Integer getBoncId() {
        return boncId;
    }

    public void setBoncId(Integer boncId) {
        this.boncId = boncId;
    }

    public Integer getStatusBaru() {
        return statusBaru;
    }

    public void setStatusBaru(Integer statusBaru) {
        this.statusBaru = statusBaru;
    }

    public Integer getStatusRevisi() {
        return statusRevisi;
    }

    public void setStatusRevisi(Integer statusRevisi) {
        this.statusRevisi = statusRevisi;
    }

    public String getKetRealisasi() {
        return ketRealisasi;
    }

    public void setKetRealisasi(String ketRealisasi) {
        this.ketRealisasi = ketRealisasi;
    }

    public String getFotometer() {
        return fotometer;
    }

    public void setFotometer(String fotometer) {
        this.fotometer = fotometer;
    }

    public String getFotopersil() {
        return fotopersil;
    }

    public void setFotopersil(String fotopersil) {
        this.fotopersil = fotopersil;
    }

    public String getFotopelanggan() {
        return fotopelanggan;
    }

    public void setFotopelanggan(String fotopelanggan) {
        this.fotopelanggan = fotopelanggan;
    }

    public String getFotottd() {
        return fotottd;
    }

    public void setFotottd(String fotottd) {
        this.fotottd = fotottd;
    }
}
