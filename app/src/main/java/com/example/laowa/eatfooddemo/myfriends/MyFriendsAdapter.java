package com.example.laowa.eatfooddemo.myfriends;

/*
 *
 * Created by Administrator on 2017-10-30.
 */


public class MyFriendsAdapter {
    int friends_pic;
    private String friends_name;
    private float friends_star;


    public MyFriendsAdapter(int friends_pic, String friends_name, float friends_star) {
        this.friends_name = friends_name;
        this.friends_pic = friends_pic;
        this.friends_star = friends_star;
    }

    public int getFriends_pic() {
        return friends_pic;
    }

    public void setFriends_pic(int friends_pic) {
        this.friends_pic = friends_pic;
    }

    public String getFriends_name() {
        return friends_name;
    }

    public void setFriends_name(String friends_name) {
        this.friends_name = friends_name;
    }

    public float getFriends_star() {
        return friends_star;
    }

    public void setFriends_star(float friends_star) {
        this.friends_star = friends_star;
    }
}
