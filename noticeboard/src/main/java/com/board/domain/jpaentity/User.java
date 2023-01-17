package com.board.domain.jpaentity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User {

    @Id
    @Column(name = "u_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "u_name")
    private String name;

    @Column(name = "u_password")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Board> boardList = new ArrayList<>();

}
