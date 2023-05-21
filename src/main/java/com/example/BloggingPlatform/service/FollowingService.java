package com.example.BloggingPlatform.service;

import com.example.BloggingPlatform.model.Following;
import com.example.BloggingPlatform.model.User;
import com.example.BloggingPlatform.repository.IFollowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowingService {

    @Autowired
    IFollowingRepository followingRepo;

    public void saveFollowing(User myUser, User otherUser) {
        Following followingRecord = new Following(null,myUser,otherUser);
        followingRepo.save(followingRecord);
    }
}
