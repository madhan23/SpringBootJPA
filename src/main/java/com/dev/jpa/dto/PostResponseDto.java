package com.dev.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDto {
    private Integer postId;
    private String userId;
    private String title;
    private String  desc;
}
