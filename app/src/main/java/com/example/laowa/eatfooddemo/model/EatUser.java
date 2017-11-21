package com.example.laowa.eatfooddemo.model;

import android.graphics.Bitmap;

/**
 *
 * Created by Administrator on 2017/10/26.
 */

public class EatUser {
    private String userName;
    private String userEmail;
    private String userNumber;
    private String userSchool;
    private Bitmap userHeadPhoto;
    private String userPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserSchool() {
        return userSchool;
    }

    public void setUserSchool(String userSchool) {
        this.userSchool = userSchool;
    }

    public Bitmap getUserHeadPhoto() {
        return userHeadPhoto;
    }

    public void setUserHeadPhoto(Bitmap userHeadPhoto) {
        this.userHeadPhoto = userHeadPhoto;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
