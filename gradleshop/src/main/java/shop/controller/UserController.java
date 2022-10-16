package shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import shop.entity.Member;
import shop.dto.MemberFormDto;
import shop.service.UserService;

import javax.validation.Valid;
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/sign")
    public String userForm(Model model){
        System.out.println("Login controller");
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "sign"; //templates 에서 시작하는 html 이름
    }
    @PostMapping(value = "/sign")
    public String newMember(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "redirect:/";
        }

        try {
            Member member = Member.createUser(memberFormDto, passwordEncoder);
            userService.saveMember(member);
        } catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "sign";
        }

        return "sign"; //로그인 성공시 가는 url
    }

    @GetMapping(value = "/loginAction")
    public String loginMember(Model model){
//        model.addAttribute("loginSuccessMsg", "로그인성공");
        return "member/userIndex";
    }

//    @GetMapping(value = "/sign/login/error")
//    public String loginError(Model model){
//        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요");
//        return "error";
//    }

}
