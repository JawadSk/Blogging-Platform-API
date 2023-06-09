package com.example.BloggingPlatform.controller;

import com.example.BloggingPlatform.model.Post;
import com.example.BloggingPlatform.model.Users;
import com.example.BloggingPlatform.service.PostService;
import com.example.BloggingPlatform.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    TokenService authService;

    @PostMapping()
    public ResponseEntity<String> addPost(@Valid @RequestParam String email , @RequestParam String token , @RequestBody Post post){
        HttpStatus status;
        String msg = "";
        if(authService.authenticate(email,token))
        {
            Users users =  authService.findUserByToken(token);
            post.setUsers(users);
            postService.addPost(post);
            msg = " Post posted successfully";
            status = HttpStatus.OK;
        }
        else
        {
            msg = "Invalid user";
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<String>(msg , status);
    }

    @GetMapping()
    public ResponseEntity<List<Post>> getAllPosts(@RequestParam String email , @RequestParam String token){
        HttpStatus status;
        List<Post> postList = null;
        if(authService.authenticate(email,token))
        {
            postList = postService.getAllPosts(token);
            status = HttpStatus.OK;
        }
        else
        {

            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<List<Post>>(postList , status);
    }

    @GetMapping("/{postId}/likeCount")
    long getLikesForPost(@PathVariable Long postId)
    {
        return postService.getLikes(postId);
    }
}
