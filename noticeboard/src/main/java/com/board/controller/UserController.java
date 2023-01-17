package com.board.controller;

import com.board.domain.dto.request.UserRequestDto;
import com.board.domain.dto.response.UserResponseDto;
import com.board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/signUp")
    public String signUp(Model model){
        model.addAttribute("userRequestDto", new UserRequestDto());
        return "/user/signup";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("userRequestDto", new UserRequestDto());
        return "/user/login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.setAttribute("name",null);
        return "redirect:/";
    }
    @PostMapping("/signUp")
    public String signUp(@Valid UserRequestDto requestDto, BindingResult result){

        if(result.hasErrors()){
            return "user/signup";
        }
        userService.join(requestDto);
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@Valid UserRequestDto requestDto, BindingResult result, HttpSession session){
        if(result.hasErrors()){
            return "user/login";
        }
        UserResponseDto loginUser = userService.login(requestDto);
        if(loginUser != null){
            session.setAttribute("name",loginUser.getName());
            return "redirect:/";
        }
        return "user/login";
    }
}
