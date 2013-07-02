package com.github.darogina.beer30.repository;

import com.github.darogina.beer30.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
