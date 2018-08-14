package com.example.apps.oktaatr.pdam_controlling.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ListBoncModel {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("messaage")
    @Expose
    private String messaage;
    @SerializedName("bonc")
    @Expose
    private List<Bonc> bonc = null;

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

    public List<Bonc> getBonc() {
        return bonc;
    }

    public void setBonc(List<Bonc> bonc) {
        this.bonc = bonc;
    }
}
