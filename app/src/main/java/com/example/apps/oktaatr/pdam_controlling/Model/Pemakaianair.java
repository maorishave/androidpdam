package com.example.apps.oktaatr.pdam_controlling.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pemakaianair {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("tglcatat")
    @Expose
    private String tglcatat;
    @SerializedName("mtlalu")
    @Expose
    private Integer mtlalu;
    @SerializedName("mtkini")
    @Expose
    private Integer mtkini;
    @SerializedName("mair")
    @Expose
    private Integer mair;
    @SerializedName("idbonc")
    @Expose
    private Object idbonc;
    @SerializedName("idpel")
    @Expose
    private Integer idpel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTglcatat() {
        return tglcatat;
    }

    public void setTglcatat(String tglcatat) {
        this.tglcatat = tglcatat;
    }

    public Integer getMtlalu() {
        return mtlalu;
    }

    public void setMtlalu(Integer mtlalu) {
        this.mtlalu = mtlalu;
    }

    public Integer getMtkini() {
        return mtkini;
    }

    public void setMtkini(Integer mtkini) {
        this.mtkini = mtkini;
    }

    public Integer getMair() {
        return mair;
    }

    public void setMair(Integer mair) {
        this.mair = mair;
    }

    public Object getIdbonc() {
        return idbonc;
    }

    public void setIdbonc(Object idbonc) {
        this.idbonc = idbonc;
    }

    public Integer getIdpel() {
        return idpel;
    }

    public void setIdpel(Integer idpel) {
        this.idpel = idpel;
    }
}
