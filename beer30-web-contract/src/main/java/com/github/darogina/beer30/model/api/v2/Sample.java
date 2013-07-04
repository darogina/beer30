package com.github.darogina.beer30.model.api.v2;

import java.util.Date;

public class Sample extends BaseModel {

    private Long id;
    private String name;

    public Sample() {}

    public Sample(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Sample(int version, Date createDate, Date lastUpdate, String createdBy, String changedBy, String uuid, Long id, String name) {
        super(version, createDate, lastUpdate, createdBy, changedBy, uuid);
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
