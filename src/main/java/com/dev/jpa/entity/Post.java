package com.dev.jpa.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    private String title;
    private String  desc;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    @OneToMany(fetch = FetchType.LAZY,cascade =CascadeType.ALL)
    @JoinColumn(name = "postId")
    private List<Comment> comments;

    @CreationTimestamp
    private LocalDateTime  createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
