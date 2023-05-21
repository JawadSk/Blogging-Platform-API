package com.example.BloggingPlatform.repository;

import com.example.BloggingPlatform.model.Post;
import com.example.BloggingPlatform.model.PostLike;
import com.example.BloggingPlatform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILikeRepository extends JpaRepository<PostLike, Long> {
    long countByPost_PostId(Long postId);
}
