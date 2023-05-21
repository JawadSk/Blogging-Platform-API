package com.example.BloggingPlatform.repository;

import com.example.BloggingPlatform.model.Following;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFollowingRepository extends JpaRepository<Following, Long> {

    Long countByUser_userId(long userId);
}
