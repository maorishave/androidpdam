package com.example.apps.oktaatr.pdam_controlling.Model;

import java.util.ArrayList;

public class LoginModel {
    public int code;
    public String description;
    public String message;
    private Data data;
    //private ArrayList<DataUserModel> dataUserModels;

    public Data getData() {
        return data;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getMessage() {
        return message;
    }
}
