package com.example.BloggingPlatform.repository;

import com.example.BloggingPlatform.model.Follower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFollowerRepository  extends JpaRepository<Follower, Long> {
}
