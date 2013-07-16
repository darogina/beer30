package com.github.darogina.beer30.entity;

import com.github.darogina.beer30.enums.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Table(name = "ROLE")
public class Role extends BaseEntity implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "AUTHORITY", nullable = false, unique = true)
    private String authority;

    public Role() {
        this(Authority.ROLE_USER);
    }

    public Role(Authority authority) {
        Assert.notNull(authority, "authority is required; it must not be null");
        this.authority = authority.name();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;

        Role role = (Role) o;

        if (!authority.equals(role.authority)) return false;
        if (!id.equals(role.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + authority.hashCode();
        return result;
    }
}
