package com.example.BloggingPlatform.repository;

import com.example.BloggingPlatform.model.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILikeRepository extends JpaRepository<PostLike, Long> {
    long countByPost_PostId(Long postId);
}
