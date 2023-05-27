package com.example.BloggingPlatform.service;

import com.example.BloggingPlatform.dto.SignInInput;
import com.example.BloggingPlatform.dto.SignInOutput;
import com.example.BloggingPlatform.dto.SignUpOutput;
import com.example.BloggingPlatform.model.AuthenticationToken;
import com.example.BloggingPlatform.model.PostLike;
import com.example.BloggingPlatform.model.Users;
import com.example.BloggingPlatform.repository.ITokenRepository;
import com.example.BloggingPlatform.repository.IUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepo;

    @Autowired
    PostService postService;

    @Autowired
    ITokenRepository tokenRepo;

    @Autowired
    FollowingService followingService;

    @Autowired
    FollowerService followerService;

    @Autowired
    LikeService likeService;

    @Autowired TokenService tokenService;
    public SignUpOutput signUp(Users signUpDto) {


        //check if user exists or not based on email
        //User user = userRepo.findFirstByEmail(signUpDto.getEmail());
        Users users = userRepo.findFirstByEmail(signUpDto.getEmail());

        if(users != null)
        {
            throw new IllegalStateException("Blog user already exists!!!!...sign in instead");
        }


        String encryptedPassword = null;

        try {
            encryptedPassword = encryptPassword(signUpDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //signUpDto.setPassword(encryptedPassword);
        //userRepo.save(signUpDto);

       // return new SignUpOutput("Blog user registered","Blog account created successfully");

        users = new Users(signUpDto.getFirstName(), signUpDto.getLastName(), signUpDto.getBlogName(),signUpDto.getBlogBio(), encryptedPassword, signUpDto.getDob(),signUpDto.getEmail(), signUpDto.getPhoneNumber(), signUpDto.isBlueTicked());


        userRepo.save(users);

        return new SignUpOutput("App User registered","App user account created successfully");

    }

    private String encryptPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");

        md5.update(userPassword.getBytes());
        byte[] digested = md5.digest();

        String hash = DatatypeConverter.printHexBinary(digested);

        return hash;

    }

    public SignInOutput signIn(SignInInput signInDto) {
        //check if user exists or not based on email
        Users users = userRepo.findFirstByEmail(signInDto.getEmail());

        if(users == null)
        {
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        String encryptedPassword = null;

        try {
            encryptedPassword = encryptPassword(signInDto.getPassword());
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }

        //match it with database encrypted password

        boolean isPasswordValid = encryptedPassword.equals(users.getPassword());

        if(!isPasswordValid)
        {
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        AuthenticationToken token = new AuthenticationToken(users);

        tokenService.saveToken(token);

        //set up output response

        return new SignInOutput("Authentication Successfull !!!", token.getToken());


    }


    public void updateUser(Users users, String token) {
        Users originalUsers = tokenRepo.findFirstByToken(token).getUsers();


        if(!(users.getFirstName().isEmpty())){
            originalUsers.setFirstName(users.getFirstName());
        }
        if((users.getLastName()!=null)){
            originalUsers.setLastName(users.getLastName());
        }
        if((users.getPassword()!=null)){
            String encryptedPassword = null;

            try {
                encryptedPassword = encryptPassword(users.getPassword());
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

            originalUsers.setPassword(encryptedPassword);
        }

        if((users.getPhoneNumber()!=null)){
            Pattern p = Pattern.compile("\\d{2}-\\d{10}");

            Matcher m = p.matcher(users.getPhoneNumber());
            if( (m.find() && m.group().equals(users.getPhoneNumber()))){
                originalUsers.setPhoneNumber(users.getPhoneNumber());

            }else{
                throw new IllegalStateException("Enter correct details");
            }

        }

        if((users.getEmail()!=null)){
            Pattern p = Pattern.compile("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}");

            Matcher m = p.matcher(users.getEmail());
            if( (m.find() && m.group().equals(users.getEmail()))){
                originalUsers.setEmail(users.getEmail());

            }else{
                throw new IllegalStateException("Enter correct details");
            }
        }

        userRepo.save(originalUsers);




    }

    @Transactional
    public String followUser(Long myId, Long otherId) {

        if(myId == otherId)
        {
            return "Cant follow yourself!!!!";
        }
        Users myUsers = userRepo.findByUserId(myId);
        Users otherUsers = userRepo.findByUserId(otherId);

        if(myUsers !=null && otherUsers !=null) {


            followingService.saveFollowing(myUsers, otherUsers);

            followerService.saveFollower(otherUsers, myUsers);

            return "Followed Successfully!!!!!";
        }
        else
        {
            return "Users are invalid!!!";
        }
    }

    public String toggleBlueTick(Long id, boolean blueTick) {
        Users users = userRepo.findByUserId(id);

        if(users !=null) {
            users.setBlueTicked(blueTick);
            userRepo.save(users);
            return "Blue tick was set to.." + blueTick;
        }
        else
        {
            return "user doesn't exist";
        }

    }

    public void like(PostLike postLike) {
        likeService.like(postLike);
    }
}
