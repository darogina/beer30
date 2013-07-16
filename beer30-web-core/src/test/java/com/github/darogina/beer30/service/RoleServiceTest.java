package com.github.darogina.beer30.service;

import com.github.darogina.beer30.entity.Role;
import com.github.darogina.beer30.enums.Authority;
import org.resthub.test.AbstractTest;
import org.springframework.test.context.ActiveProfiles;
import org.testng.annotations.Test;

import javax.inject.Inject;

import static org.fest.assertions.api.Assertions.assertThat;


@ActiveProfiles("resthub-jpa")
public class RoleServiceTest extends AbstractTest {

    @Inject
    private RoleService roleService;

    @Test
    public void findByAuthorityTest() {
        Role role = roleService.findByAuthority(Authority.ROLE_USER);
        assertThat(role).isNotNull();
        assertThat(role.getId()).isPositive();
        assertThat(role.getAuthority()).isEqualTo(Authority.ROLE_USER.name());
        assertThat(role).isEqualTo(roleService.findByAuthority(Authority.ROLE_USER));
    }

}
