package com.board.domain.dto.request;

import com.board.domain.jpaentity.User;
import lombok.*;

import javax.validation.constraints.NotEmpty;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserRequestDto {

    @NotEmpty(message = "아이디는 필수 입니다.")
    private String name;
    @NotEmpty(message = "비밀번호는 필수 입니다.")
    private String password;

    public User toEntity(){
        return User.builder()
                .name(getName())
                .password(getPassword())
                .build();
    }
}
