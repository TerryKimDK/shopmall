package controller;

import lombok.RequiredArgsConstructor;
import model.MemberDTO;
import org.springframework.stereotype.Controller;
import service.MemberService;
import view.LoginView;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    public void LoginView() {
        new LoginView();
    }

    public void idCheck(MemberDTO input) {
        memberService.idCheck(input);
    }

}
