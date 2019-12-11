package com.smnadim21.food1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Contents {

/*    "success": true,
            "message": "Request successful!",
            "name": "APP_food1",
            "app_id": "016187",
            "app_password": "123456",
            "sms_keyword": "ballu",
            "ussd_code": "*214*8080#"*/

    @SerializedName("success")
    @Expose
    Boolean stat;

    @SerializedName("message")
    @Expose
    String message;

    @SerializedName("name")
    @Expose
    String name;

    @SerializedName("app_id")
    @Expose
    String app_id;
    @SerializedName("app_password")
    @Expose
    String app_password;

    @SerializedName("sms_keyword")
    @Expose
    String sms_keyword;

    @SerializedName("ussd_code")
    @Expose
    String ussd_code;


    @SerializedName("contents")
    @Expose
    List<CatItem> contents;


    public Boolean getStat() {
        return stat;
    }

    public void setStat(Boolean stat) {
        this.stat = stat;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getApp_password() {
        return app_password;
    }

    public void setApp_password(String app_password) {
        this.app_password = app_password;
    }

    public String getSms_keyword() {
        return "start "+ sms_keyword;
    }
    public void setSms_keyword(String sms_keyword) {
        this.sms_keyword = sms_keyword;
    }

    public String getUssd_code() {
        return ussd_code;
    }

    public void setUssd_code(String ussd_code) {
        this.ussd_code = ussd_code;
    }

    public List<CatItem> getContents() {
        return contents;
    }

    public void setContents(List<CatItem> contents) {
        this.contents = contents;
    }
}
