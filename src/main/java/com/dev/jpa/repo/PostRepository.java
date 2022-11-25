package com.dev.jpa.repo;

import com.dev.jpa.dto.PostDtoView;
import com.dev.jpa.entity.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository  extends JpaRepository<Post,Integer> {

/*    @Query("select new com.dev.jpa.dto.PostResponseDto(p.postId,p.userId,p.title,p.desc) from Post p where p.postId=?1")
    Optional<PostResponseDto> getPost(Integer postId);*/

    @Query(value = "select post_id,user_id,title,desc from post where user_id=?1",nativeQuery = true)
    List<PostDtoView> findByPostIdd(Integer UserId, Pageable pageable);
}
