package com.smnadim21.food1.advert;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by Atiar on 5/23/18.
 */

public class SP {

   // private static final String defaultServerAddress = "http://vios.datasysbd.net/";

    private static final String PREFS_NAME = "akfdghliif";
    private static final String fcm_token = "norinsvsior";
    private static final String sub_code = "nvaoifgoif";


    private static final String ad_stat = "pogrfboar";
    private static final String sub_stat = "bwgadseori";
    private static final String sub_click = "lkhlakdhlk";

    private static final String contents = "alsfguaofi";


    /*****************************//* Strat shared preferences */

    /******************************/

    public static boolean setPreference(String key, String value) {
        SharedPreferences settings = AppConfig.getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        return editor.commit();
    }

    public static String getPreference(String key) {
        SharedPreferences settings = AppConfig.getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return settings.getString(key, "none");
    }

    public static boolean setPreferenceInt(String key, int value) {
        SharedPreferences settings = AppConfig.getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(key, value);
        return editor.commit();
    }

    public static int getPreferenceInt(String key) {
        SharedPreferences settings = AppConfig.getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return settings.getInt(key, 0);
    }


    public static boolean setPreferenceBool(String key, Boolean value) {
        SharedPreferences settings = AppConfig.getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }

    public static boolean getPreferenceBool(String key) {
        SharedPreferences settings = AppConfig.getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return settings.getBoolean(key, false);
    }


    public static void setadStatus(Boolean status){
        setPreferenceBool(ad_stat,status);

    }



    public static Boolean getAdStatus(){
        return getPreferenceBool(ad_stat);
    }



    public static void setSubscriptionStatus(Boolean status){
        setPreferenceBool(sub_stat,status);

    }

    public static Boolean getSubscriptionStatus(){
        return getPreferenceBool(sub_stat);
    }


    public static void setSubscriptionClicked(Boolean status){
        setPreferenceBool(sub_click,status);

    }

    public static Boolean getSubscriptionClicked(){
        return getPreferenceBool(sub_click);
    }







    public static void setFcmToken(String referalCode){
        setPreference(fcm_token,referalCode);

    }

    public static String getFcmToken(){
        return getPreference(fcm_token);
    }


    public static void setSubCode(String sub){
        setPreference(sub_code,sub);

    }

    public static String getSubCode(){
        return getPreference(sub_code);
    }




    public static void setCacheData(String referalCode){
        setPreference(contents,referalCode);

    }

    public static String getCacheData() {
        return getPreference(contents);
    }




    /*****************************//* End shared preferences *//******************************/


}
