package com.example.BloggingPlatform.repository;

import com.example.BloggingPlatform.model.Post;
import com.example.BloggingPlatform.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByUsers(Users users);

}
