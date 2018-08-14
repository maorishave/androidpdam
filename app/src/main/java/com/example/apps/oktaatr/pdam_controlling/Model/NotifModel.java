package com.example.apps.oktaatr.pdam_controlling.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NotifModel {
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("messaage")
    @Expose
    private String messaage;
    @SerializedName("notifbaru")
    @Expose
    private Integer notifbaru;

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

    public Integer getNotifbaru() {
        return notifbaru;
    }

    public void setNotifbaru(Integer notifbaru) {
        this.notifbaru = notifbaru;
    }
}
