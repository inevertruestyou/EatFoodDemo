package com.example.laowa.eatfooddemo.mainpageone;

/*
 *
 * Created by Administrator on 2017-10-30.
 */


public class MatchPeopleAdapter {
    int people_pic;
    private String people_name;
    private String people_last_message;
    private String people_last_message_data;

    public MatchPeopleAdapter(String people_name, String people_last_message_data, String people_last_message, int people_pic) {
        this.people_name = people_name;
        this.people_last_message_data = people_last_message_data;
        this.people_last_message = people_last_message;
        this.people_pic = people_pic;
    }

    public int getPeople_pic() {
        return people_pic;
    }

    public void setPeople_pic(int people_pic) {
        this.people_pic = people_pic;
    }

    public String getPeople_name() {
        return people_name;
    }

    public void setPeople_name(String people_name) {
        this.people_name = people_name;
    }

    public String getPeople_numstar() {
        return people_last_message_data;
    }

    public void setPeople_numstar(String people_numstar) {
        this.people_last_message_data = people_numstar;
    }

    public String getPeople_last_message() {
        return people_last_message;
    }

    public void setPeople_last_message(String people_last_message) {
        this.people_last_message = people_last_message;
    }
}
