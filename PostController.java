package com.dev.jpa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.jpa.dto.PostCommentRequest;
import com.dev.jpa.dto.PostCommentResponse;
import com.dev.jpa.dto.PostDtoView;
import com.dev.jpa.dto.PostRequest;
import com.dev.jpa.entity.Post;
import com.dev.jpa.service.PostService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/posts")
@AllArgsConstructor
@Slf4j
public class PostController {

    private final PostService postService;
    @PostMapping("/")
    public Post savePost(@RequestBody PostRequest request) {
    	log.info(" Save Post payload {}",request);
        return postService.savePost(request);
    }

    @GetMapping("/{userId}")
    public List<PostDtoView> getAllPostByUser (@PathVariable final Integer userId){
    	log.info("Fetch all Post Details   by User Id :: {}",userId);
        return  postService.getAllPostByUser(userId);
    }
    
    
    @GetMapping("/{postId}/comments")
    public List<PostCommentResponse> getPostComments (@PathVariable final Integer postId){
    	log.info("fetch all comments for particular post :: ",postId);
        return  postService.getPostComments(postId);
    }
    
    @PostMapping("/{postId}/comments")
    public PostCommentResponse addCommentToPost (@PathVariable final Integer postId,@RequestBody PostCommentRequest request){	
        return  postService.addCommentToPost(postId,request);
    }
    
    
}



