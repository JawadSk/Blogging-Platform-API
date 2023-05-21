package com.example.BloggingPlatform.service;

import com.example.BloggingPlatform.repository.IAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    UserService userService;

    @Autowired
    private IAdminRepository adminRepo;

    public String toggleBlueTick(Long id, boolean blueTick) {
        return userService.toggleBlueTick(id,blueTick);

    }
}
