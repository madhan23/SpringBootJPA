package com.dev.jpa.dto;

import com.dev.jpa.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostRequestDto {
    private String title;
    private String  desc;
    private Integer userId;
    private List<Comment> comments;
}
