package com.example.meishimeike;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class SearchBean {
    @Id
    String name;
    long time;
    @Generated(hash = 1586755042)
    public SearchBean(String name, long time) {
        this.name = name;
        this.time = time;
    }
    @Generated(hash = 562045751)
    public SearchBean() {
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getTime() {
        return this.time;
    }
    public void setTime(long time) {
        this.time = time;
    }

}
