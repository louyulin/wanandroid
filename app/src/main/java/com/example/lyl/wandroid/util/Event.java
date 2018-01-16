package com.example.lyl.wandroid.util;

/**
 * Created by dllo on 18/1/12.
 */

public class Event {
    String msg;
    int position;
    boolean iscollect;

    public Event(String msg, int position, boolean iscollect) {
        this.msg = msg;
        this.position = position;
        this.iscollect = iscollect;
    }

    public String getMsg() {
        return msg;
    }

    public int getPosition() {
        return position;
    }

    public boolean iscollect() {
        return iscollect;
    }
}
