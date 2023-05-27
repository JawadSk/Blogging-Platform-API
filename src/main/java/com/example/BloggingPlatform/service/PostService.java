package com.example.BloggingPlatform.service;

import com.example.BloggingPlatform.model.Post;
import com.example.BloggingPlatform.model.Users;
import com.example.BloggingPlatform.repository.IPostRepository;
import com.example.BloggingPlatform.repository.ITokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class PostService {

    @Autowired
    IPostRepository postRepo;

    @Autowired
    LikeService likeService;

    @Autowired
    ITokenRepository tokenRepo;
    public void addPost(Post post) {
        postRepo.save(post);
    }

    public List<Post> getAllPosts(String token) {
        Users users = tokenRepo.findFirstByToken(token).getUsers();


        List<Post> postList = postRepo.findByUsers(users);

        return postList;


    }

    public long getLikes(Long postId) {

        return likeService.getLikes(postId);
    }

}
