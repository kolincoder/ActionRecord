package com.mohen.edu.record.library;

/**
 * Created by Kenneth on 2017/9/29.
 */

public class Cfg {

    private String name;
    private String time;
    private String tag;
    private String oid;

    public Cfg(String name, String time, String oid){
        this.name = name;
        this.time = time;
        this.oid = oid;
    }

    public Cfg(String name, String time, String oid, String tag){
        this.name = name;
        this.time = time;
        this.oid = oid;
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
