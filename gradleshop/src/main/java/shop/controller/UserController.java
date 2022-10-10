package shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import shop.domain.User;
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
            return "sign";
        }

        try {
            User user = User.createUser(memberFormDto, passwordEncoder);
            userService.saveUser(user);
        } catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "sign";
        }

        return "sign"; //templates 에서 시작하는 html 이름
    }
}
