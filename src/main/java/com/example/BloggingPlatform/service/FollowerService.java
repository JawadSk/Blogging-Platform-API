package com.example.BloggingPlatform.service;

import com.example.BloggingPlatform.model.Follower;
import com.example.BloggingPlatform.model.User;
import com.example.BloggingPlatform.repository.IFollowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowerService {

    @Autowired
    IFollowerRepository followerRepo;

    public void saveFollower(User myUser, User otherUser) {


        Follower follower = new Follower(null,myUser,otherUser);

        followerRepo.save(follower);
    }
}
