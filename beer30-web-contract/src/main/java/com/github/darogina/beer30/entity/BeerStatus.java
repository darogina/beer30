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

    @OneToOne(optional = false, orphanRemoval = false)
    @JoinColumn(name = "USER_ID")
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
}
