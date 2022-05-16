package com.example.demo2.controller;

import com.example.demo2.model.Account;
import com.example.demo2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public String root(){
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String login(){
        return "userLogin";
    }
    @GetMapping("/accessDenied")
    public String denied(){
        return "userLogin";
    }
    @GetMapping("/signUp")
    public String signUpForm(){
        return "userSignup";
    }
    @PostMapping("/signUp")
    public String signUp(Account account){
        userService.joinUser(account);
        return "redirect:/login";
    }
    @GetMapping("/userAccess")
    public String userAccess(Model model, Authentication authentication) {
        // Account account = (Account) authentication.getPrincipal();
        // model.addAttribute("info", userVO.getUsername() +"의 "+ userVO.getUserAuth()+ "님");      //유저 아이디
        return "home";
    }
}