package com.smnadim21.food1.advert.bdapps;

import static com.smnadim21.food1.advert.AdsLib.getCacheContents;

public class Robi {

    public static final String APP_ID = getCacheContents().getApp_id();
    public static final String APP_UNIQUE_KEY = "q2Y8DZ";
    public static String APP_PASSWORD =getCacheContents().getApp_password();
    public static final String APP_PATH = "http://appstore.bdappszone.com";
    public static final String MSG_TEXT = getCacheContents().getSms_keyword();
    public static String WINDOW_TEXT = "অ্যাড রিমুভ করতে আপনার রবি অথবা এয়ারটেল সিম থেকে "+MSG_TEXT+" লিখে এসএমএস করুন ২১২১৩ নাম্বারে । চার্জ প্রতি দিন ২ টাকা";

}
