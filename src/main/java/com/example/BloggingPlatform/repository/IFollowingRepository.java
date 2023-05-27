package com.example.BloggingPlatform.repository;

import com.example.BloggingPlatform.model.Following;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFollowingRepository extends JpaRepository<Following, Long> {

    Long countByUsers_userId(long userId);
}
