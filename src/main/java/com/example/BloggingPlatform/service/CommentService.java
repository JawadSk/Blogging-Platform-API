package com.example.BloggingPlatform.service;

import com.example.BloggingPlatform.model.Comment;
import com.example.BloggingPlatform.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    ICommentRepository commentRepo;


    public String addComment(Comment comment) {
        Comment rComment = commentRepo.save(comment);
        if(rComment == null)
        {
            return "Comment not saved...!";
        }
        else
        {
            return "Comment saved...!";
        }
    }
}
