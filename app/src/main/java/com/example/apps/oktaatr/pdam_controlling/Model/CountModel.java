package com.example.apps.oktaatr.pdam_controlling.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountModel {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("messaage")
    @Expose
    private String messaage;
    @SerializedName("baru")
    @Expose
    private Integer baru;
    @SerializedName("proses")
    @Expose
    private Integer proses;
    @SerializedName("kirim")
    @Expose
    private Integer kirim;

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

    public String getMessaage() {
        return messaage;
    }

    public void setMessaage(String messaage) {
        this.messaage = messaage;
    }

    public Integer getBaru() {
        return baru;
    }

    public void setBaru(Integer baru) {
        this.baru = baru;
    }

    public Integer getProses() {
        return proses;
    }

    public void setProses(Integer proses) {
        this.proses = proses;
    }

    public Integer getKirim() {
        return kirim;
    }

    public void setKirim(Integer kirim) {
        this.kirim = kirim;
    }
}
