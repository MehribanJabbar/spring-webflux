package com.example.msusers.dao.repository;

import com.example.msusers.dao.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {
    User findByUsername(String username);
}
