package com.example.apps.oktaatr.pdam_controlling.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailTugasModel {
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("messaage")
    @Expose
    private String messaage;
    @SerializedName("detail")
    @Expose
    private Detail detail;
    @SerializedName("pemakaianair")
    @Expose
    private List<Pemakaianair> pemakaianair = null;

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

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public List<Pemakaianair> getPemakaianair() {
        return pemakaianair;
    }

    public void setPemakaianair(List<Pemakaianair> pemakaianair) {
        this.pemakaianair = pemakaianair;
    }

}
