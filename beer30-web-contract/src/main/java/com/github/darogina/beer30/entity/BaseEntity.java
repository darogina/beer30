package com.github.darogina.beer30.entity;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
public class BaseEntity implements Serializable {

    @Transient
    private static final long serialVersionUID = 8277812532939023805L;

    @Transient
    private static final String AUTOMATED_USER = "automatedUser";

    @Version
    @Column(name = "VERSION")
    private int version = 0;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE", nullable = false)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_UPDATE", nullable = false)
    private Date lastUpdate;

    @Column(name = "CREATED_BY", nullable = true)
    private String createdBy;

    @Column(name = "CHANGED_BY", nullable = true)
    private String changedBy;

    @Column(name = "UUID", nullable = false, unique = true)
    private String uuid;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Date getCreateDate() {
        return (Date) createDate.clone();
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdate() {
        return (Date) lastUpdate.clone();
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
        if (uuid == null) {
            uuid = UUID.randomUUID().toString();
        }
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @PrePersist
    protected void onCreate() {
        changedBy = createdBy = getUserFromSecurityContext();
        lastUpdate = createDate = new Date();

        // Generate a new UUID for the entity
        getUuid();
    }

    @PreUpdate
    protected void onUpdate() {
        changedBy = getUserFromSecurityContext();
        lastUpdate = new Date();
    }

    @Transient
    private String getUserFromSecurityContext() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            Object user = authentication.getPrincipal();
            if(user instanceof User) {
                return ((User) user).getUsername();
            } else if(user instanceof String) {
                return (String) user;
            } else {
                changedBy = AUTOMATED_USER;
            }
        }

        return AUTOMATED_USER;
    }
}
