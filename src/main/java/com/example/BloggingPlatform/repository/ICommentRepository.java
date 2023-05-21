package com.example.BloggingPlatform.repository;

import com.example.BloggingPlatform.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Long> {
}
