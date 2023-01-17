package com.board.service;

import com.board.domain.dto.request.UserRequestDto;
import com.board.domain.dto.response.UserResponseDto;
import com.board.domain.jpaentity.User;
import com.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long join(UserRequestDto requestDto){
        User user = getUser(requestDto);
        validateUser(user);
        userRepository.save(user);
        return user.getId();
    }

    private User getUser(UserRequestDto requestDto) {
        return requestDto.toEntity();
    }

    private void validateUser(User user) { //중복 아이디 검증
        userRepository.findByName(user.getName())
                .ifPresent(u -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public UserResponseDto login(UserRequestDto requestDto){
        User findUser = userRepository.findByName(requestDto.getName()).orElse(User.builder().build());
        System.out.println(findUser);
        if(findUser.getName() != null && findUser.getPassword().equals(requestDto.getPassword())) {
            return UserResponseDto
                    .builder()
                    .name(findUser.getName())
                    .password(findUser.getPassword())
                    .build();
        }
        return null;
    }
}
