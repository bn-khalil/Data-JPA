package org.dataJpa.jpa_e1.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String content;

//    @JoinColumn(name = "post_id")
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @Override
    public String toString() {
        return "Post{" +
                "Id=" + Id +
                ", content='" + content + '\'' +
                ", comments={" + comments.stream().map(Comment::getMessage).toList() +
                "}}";
    }
}
