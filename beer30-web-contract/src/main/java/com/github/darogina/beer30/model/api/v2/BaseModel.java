package com.github.darogina.beer30.model.api.v2;

import com.github.darogina.beer30.model.api.ApiModel;

import java.util.Date;

public class BaseModel implements ApiModel {

    public static final String API_VERSION = "v2";

    private int version = 0;
    private Date createDate;
    private Date lastUpdate;
    private String createdBy;
    private String changedBy;
    private String uuid;
    private String apiVersion = API_VERSION;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(String changedBy) {
        this.changedBy = changedBy;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getApiVersion() {
        return apiVersion;
    }
}
