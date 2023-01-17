package com.board.domain.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserResponseDto {

    private String name;
    private String password;
}
