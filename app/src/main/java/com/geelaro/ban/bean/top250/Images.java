package com.geelaro.ban.bean.top250;

import java.io.Serializable;

/**
 * Created by LEE on 18/3/8.
 */
public class Images implements Serializable {
    private String small;

    private String large="";

    private String medium;


    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }
}
