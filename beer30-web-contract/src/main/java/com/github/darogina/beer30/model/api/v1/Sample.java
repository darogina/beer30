package com.github.darogina.beer30.model.api.v1;

import org.joda.time.DateTime;

public class Sample extends BaseModel {

    private String name;

    public Sample() {}

    public Sample(String name) {
        this.name = name;
    }

    public Sample(int version, DateTime createDate, DateTime lastUpdate, String createdBy, String changedBy, String uuid, String name) {
        super(version, createDate, lastUpdate, createdBy, changedBy, uuid);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
