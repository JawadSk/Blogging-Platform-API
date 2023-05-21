package com.example.BloggingPlatform.repository;

import com.example.BloggingPlatform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    User findFirstByEmail(String email);

    User findByUserId(Long id);
}
