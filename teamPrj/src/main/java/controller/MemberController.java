package controller;

import lombok.RequiredArgsConstructor;
import model.MemberDTO;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import service.MemberService;
import view.JoinView;
import view.LoginView;
import view.MainView;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    public void loginView() {
        new LoginView();
//        LoginView loginView = new LoginView();
    }

    public int login(MemberDTO input) {
        return memberService.login(input);
    }

    public void joinView() {
        new JoinView();
    }

    public int join(MemberDTO input) {
        return memberService.join(input);
    }

    public int idCheck(MemberDTO input) {
        return memberService.idCheck(input);
    }

    public void mainView() {
        new MainView();
    }

    private static MemberController instance;

    public static MemberController getInstance() {
        if (instance == null)
            instance = new ClassPathXmlApplicationContext("bean-config.xml").getBean("memberController", MemberController.class);

        return instance;
    }

}
