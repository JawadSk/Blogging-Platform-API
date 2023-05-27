package com.example.BloggingPlatform.repository;

import com.example.BloggingPlatform.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<Users, Long> {

    Users findFirstByEmail(String email);

    Users findByUserId(Long id);
}
