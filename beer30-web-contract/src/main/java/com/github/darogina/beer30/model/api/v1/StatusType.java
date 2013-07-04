package com.github.darogina.beer30.model.api.v1;

import java.util.Date;

public class StatusType extends BaseModel {

    private Long id;
    private String name;
    private String description;

    public StatusType() {}

    public StatusType(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public StatusType(int version, Date createDate, Date lastUpdate, String createdBy, String changedBy, String uuid, Long id, String name, String description) {
        super(version, createDate, lastUpdate, createdBy, changedBy, uuid);
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
