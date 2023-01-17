package com.board.domain.jpaentity;

import lombok.Getter;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "comment")
@Getter
public class Comment {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "c_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "b_no")
    private Board board;

    @Column(name = "update_time")
    private LocalDateTime dateTime;

    @Column(name = "writer")
    private String writer;

    @Column(name = "content")
    private String content;
}
