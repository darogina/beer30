package com.github.darogina.beer30.entity;

import javax.persistence.*;

@Entity
@Table(name = "BEER_STATUS")
public class BeerStatus extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, optional = false, orphanRemoval = false)
    @JoinColumn(name = "STATUS_TYPE_ID")
    private StatusType statusType;

    @Column(name = "REASON", nullable = true)
    private String reason;

    @OneToOne(optional = true, orphanRemoval = false)
    @JoinColumn(name = "USER_ID", nullable = true)
    private User user;

    public Long getId() {
        return id;
    }

    public StatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BeerStatus)) return false;

        BeerStatus that = (BeerStatus) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (reason != null ? !reason.equals(that.reason) : that.reason != null) return false;
        if (statusType != null ? !statusType.equals(that.statusType) : that.statusType != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (statusType != null ? statusType.hashCode() : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
