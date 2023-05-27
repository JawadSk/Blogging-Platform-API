package com.example.BloggingPlatform.service;

import com.example.BloggingPlatform.model.Follower;
import com.example.BloggingPlatform.model.Users;
import com.example.BloggingPlatform.repository.IFollowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowerService {

    @Autowired
    IFollowerRepository followerRepo;

    public void saveFollower(Users myUsers, Users otherUsers) {


        Follower follower = new Follower(null, myUsers, otherUsers);

        followerRepo.save(follower);
    }
}
