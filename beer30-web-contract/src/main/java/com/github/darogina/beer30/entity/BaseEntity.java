package com.github.darogina.beer30.entity;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.jadira.usertype.dateandtime.joda.PersistentDateTime;
import org.joda.time.DateTime;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
@TypeDef(name = "jodaDateTime", defaultForType = DateTime.class, typeClass = PersistentDateTime.class)
public abstract class BaseEntity implements Serializable {

    @Transient
    private static final long serialVersionUID = 8277812532939023805L;

    @Transient
    private static final String AUTOMATED_USER = "automatedUser";

    @Version
    @Column(name = "VERSION")
    private int version = 0;

    @Column(name = "CREATE_DATE", nullable = false)
    @Type(type = "jodaDateTime")
    private DateTime createDate;

    @Column(name = "LAST_UPDATE", nullable = false)
    @Type(type = "jodaDateTime")
    private DateTime lastUpdate;

    @Column(name = "CREATED_BY", nullable = false)
    private String createdBy;

    @Column(name = "CHANGED_BY", nullable = false)
    private String changedBy;

    @Column(name = "UUID", nullable = false, unique = true)
    private String uuid;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public DateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(DateTime createDate) {
        this.createDate = createDate;
    }

    public DateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(DateTime lastUpdate) {
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
        lastUpdate = createDate = new DateTime();

        // Generate a new UUID for the entity
        getUuid();
    }

    @PreUpdate
    protected void onUpdate() {
        changedBy = getUserFromSecurityContext();
        lastUpdate = new DateTime();
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

    public abstract boolean equals(Object o);
    public abstract int hashCode();
}
