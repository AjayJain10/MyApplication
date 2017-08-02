package com.example.ajayj.myapplication.util;

import android.content.Context;

/**
 * Created by ajayj on 28-06-2017.
 */

public class LoginDetails {

    public static void storeUserDetails(Context context,String user){
        context.getSharedPreferences("IsLoginusr",context.MODE_PRIVATE).edit().putString("username",user).apply();
    }

    public static String isUser(Context context)
    {
        return context.getSharedPreferences("IsLoginusr",Context.MODE_PRIVATE).getString("username",null);
    }

    public static void storePasswordDetails(Context context,String pwd){
        context.getSharedPreferences("IsLoginpwd",context.MODE_PRIVATE).edit().putString("password",pwd).apply();
    }

    public static String isPwd(Context context)
    {
        return context.getSharedPreferences("IsLoginpwd",Context.MODE_PRIVATE).getString("password",null);
    }

    public static void storeRemindmeDetails(Context context,boolean isChecked)
    {
        context.getSharedPreferences("IsLoginRmd",context.MODE_PRIVATE).edit().putBoolean("remindme",isChecked).apply();
    }

    public static  boolean isChecked(Context context)
    {
        return  context.getSharedPreferences("IsLoginRmd",Context.MODE_PRIVATE).getBoolean("remindme",false);
    }
}
