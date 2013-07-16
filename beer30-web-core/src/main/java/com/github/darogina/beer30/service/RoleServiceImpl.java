package com.github.darogina.beer30.service;

import com.github.darogina.beer30.entity.Role;
import com.github.darogina.beer30.enums.Authority;
import com.github.darogina.beer30.repository.RoleRepository;
import org.resthub.common.service.CrudServiceImpl;
import org.springframework.util.Assert;

import javax.inject.Inject;
import javax.inject.Named;

@Named("roleService")
public class RoleServiceImpl extends CrudServiceImpl<Role, Long, RoleRepository> implements RoleService {

    @Override @Inject
    public void setRepository(RoleRepository roleRepository) {
        super.setRepository(roleRepository);
    }

    @Override
    public Role findByAuthority(Authority authority) {
        Assert.notNull(authority, "authority is required; it must not be null");

        Role role = repository.findByAuthority(authority.name());
        if (role == null) {
            role = new Role(authority);
            role = create(role);
        }

        return role;
    }
}
