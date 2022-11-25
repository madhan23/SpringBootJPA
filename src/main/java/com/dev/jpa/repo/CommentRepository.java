package com.dev.jpa.repo;

import com.dev.jpa.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository  extends JpaRepository<Comment,Integer> {
}
