package com.dev.jpa.controller;

import com.dev.jpa.dto.PostDtoView;
import com.dev.jpa.dto.PostRequestDto;
import com.dev.jpa.dto.PostResponseDto;
import com.dev.jpa.entity.Post;
import com.dev.jpa.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class PostController {

    private final PostService postService;
    @PostMapping("/posts")
    public Post savePost(@RequestBody PostRequestDto request) {
        return postService.savePost(request);
    }

    @GetMapping("/posts/{userId}")
    public List<PostDtoView> getPost (@PathVariable final Integer userId){
        return  postService.getPost(userId);
    }
}
