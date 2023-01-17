package com.board.domain.jpaentity;

import lombok.Getter;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "board")
@Getter
public class Board {

    @Id
    @Column(name = "b_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "img")
    private String img;

    @Column(name = "b_password")
    private String password;

    @Column(name = "update_time")
    private LocalDateTime dateTime;

    @Column(name = "writer")
    private String writer;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "u_id")
    private User user;

    @OneToMany(mappedBy = "board")
    private List<Comment> comments = new ArrayList<>();
}
