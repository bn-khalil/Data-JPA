package org.dataJpa.jpa_e1.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String message;

    @ManyToOne
    @JoinColumn(name = "post")
    private Post post;

    @Override
    public String toString() {
        return "Comment{" +
                "Id=" + Id +
                ", message='" + message + '\'' +
                ", post=" + post.getContent() +
                '}';
    }
}
