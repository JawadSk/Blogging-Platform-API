package com.example.BloggingPlatform.service;

import com.example.BloggingPlatform.model.Following;
import com.example.BloggingPlatform.model.Users;
import com.example.BloggingPlatform.repository.IFollowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowingService {

    @Autowired
    IFollowingRepository followingRepo;

    public void saveFollowing(Users myUsers, Users otherUsers) {
        Following followingRecord = new Following(null, myUsers, otherUsers);
        followingRepo.save(followingRecord);
    }
}
