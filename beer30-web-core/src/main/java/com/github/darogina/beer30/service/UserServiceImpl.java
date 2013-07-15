package com.github.darogina.beer30.service;

import com.github.darogina.beer30.entity.User;
import com.github.darogina.beer30.repository.UserRepository;
import org.resthub.common.service.CrudServiceImpl;

import javax.inject.Inject;
import javax.inject.Named;

@Named("userService")
public class UserServiceImpl extends CrudServiceImpl<User, Long, UserRepository> implements UserService {

    @Override @Inject
    public void setRepository(UserRepository userRepository) {
        super.setRepository(userRepository);
    }

}