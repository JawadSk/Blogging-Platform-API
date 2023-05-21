package com.example.BloggingPlatform.service;

import com.example.BloggingPlatform.model.PostLike;
import com.example.BloggingPlatform.repository.ILikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    @Autowired
    ILikeRepository likeRepo;

    public void like(PostLike postLike) {
        likeRepo.save(postLike);
    }

    public long getLikes(Long postId) {

        return likeRepo.countByPost_PostId(postId);
    }
}
