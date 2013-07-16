package com.github.darogina.beer30;

import com.github.darogina.beer30.entity.User;
import com.github.darogina.beer30.enums.Authority;
import com.github.darogina.beer30.repository.UserRepository;
import com.github.darogina.beer30.service.RoleService;
import org.resthub.common.util.PostInitialize;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;

@Named("userInitializer")
public class UserInitializer {

    @Inject
    @Named("userRepository")
    private UserRepository userRepository;

    @Inject
    @Named("roleService")
    private RoleService roleService;

    @PostInitialize
    public void init() {
        User user = new User("test1@test.com", "", "test1@test.com", "Test1First", "Test1Last", null, Arrays.asList(roleService.findByAuthority(Authority.ROLE_ADMIN)));
        User user2 = new User("test2@test.com", "", "test2@test.com", "Test2First", "Test2Last", null, Arrays.asList(roleService.findByAuthority(Authority.ROLE_USER)));

        userRepository.save(user);
        userRepository.save(user2);
    }
}