package com.github.darogina.beer30.service;

import com.github.darogina.beer30.entity.Role;
import com.github.darogina.beer30.enums.Authority;
import org.resthub.common.service.CrudService;

public interface RoleService extends CrudService<Role, Long> {

    /**
     * Get a {@code Role} by a specified {@code Authority}
     * @param authority Authority
     * @return Role
     */
    Role findByAuthority(Authority authority);

}
