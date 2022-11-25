package com.dev.jpa.service;

import com.dev.jpa.dto.PostDtoView;
import com.dev.jpa.dto.PostRequestDto;
import com.dev.jpa.entity.Post;
import com.dev.jpa.entity.User;
import com.dev.jpa.repo.CommentRepository;
import com.dev.jpa.repo.PostRepository;
import com.dev.jpa.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private  final UserRepository userRepo;
    public Post savePost(PostRequestDto request) {
        Post post = new Post();
        post.setDesc(request.getDesc());
        post.setTitle(request.getTitle());
       User user = userRepo.findById(request.getUserId()).get();
       post.setUser(user);
        post.setComments(request.getComments());


        return postRepository.save(post);
    }

    public List<PostDtoView> getPost(Integer userId) {

        Pageable pageable =  PageRequest.of(0,2);
        return postRepository.findByPostIdd(userId,pageable);
    }

}
