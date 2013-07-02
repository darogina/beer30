package com.github.darogina.beer30.entity;

import javax.persistence.*;

@Entity
@Table(name = "LINKED_ACCOUNT")
public class LinkedAccount extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @Column(name = "ACCOUNT_SOURCE", nullable = false)
    private String accountSource;

    @Column(name = "ACCOUNT_ID_TYPE", nullable = false)
    private String accountIdType;

    @Column(name = "ACCOUNT_ID", nullable = false)
    private String accountId;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAccountSource() {
        return accountSource;
    }

    public void setAccountSource(String accountSource) {
        this.accountSource = accountSource;
    }

    public String getAccountIdType() {
        return accountIdType;
    }

    public void setAccountIdType(String accountIdType) {
        this.accountIdType = accountIdType;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
