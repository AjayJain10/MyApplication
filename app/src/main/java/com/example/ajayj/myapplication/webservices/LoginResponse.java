package com.example.ajayj.myapplication.webservices;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ajayj on 04-07-2017.
 */

public class LoginResponse {
    @SerializedName("sessid")
    private String sessId;
    @SerializedName("session_name")
    private String sessionName;
    @SerializedName("token")
    private String accessToken;

    public String getSessId() {
        return sessId;
    }

    public void setSessId(String sessId) {
        this.sessId = sessId;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionNname) {
        this.sessionName = sessionNname;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
