package com.example.apps.oktaatr.pdam_controlling.Controller;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "UserPref";
    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_ID = "id";
    public static final String KEY_CODE = "code";

    public SessionManager(Context context){
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void CreateLoginSession(int id, int code){
        editor.putBoolean(IS_LOGIN, true);
        editor.putInt(KEY_ID, id);
        editor.putInt(KEY_CODE, code);

        editor.commit();
    }
    public Boolean checkLogin(){
        if (!this.isLoggedIn()){
            return false;
        }
        return true;
    }

    public HashMap<String, String> getUserDetail(){
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(KEY_ID,String.valueOf(pref.getInt(KEY_ID,0)));
        return user;
    }

    public void logoutUser() {
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();
    }


    public boolean isLoggedIn()
    {
        return pref.getBoolean(IS_LOGIN, false);
    }

    public int getKeyIdet()
    {
        return pref.getInt(KEY_ID,0);
    }
//
    public int getKeyCode() {
        return pref.getInt(KEY_CODE,0);
    }
}
