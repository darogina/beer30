package com.github.darogina.beer30.model.api.v1;

public class BeerStatus extends BaseModel {

    private Long id;
    private Long statusTypeId;
    private String reason;
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStatusTypeId() {
        return statusTypeId;
    }

    public void setStatusTypeId(Long statusTypeId) {
        this.statusTypeId = statusTypeId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
