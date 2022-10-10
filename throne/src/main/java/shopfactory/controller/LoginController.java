package shopfactory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

//    @Autowired
//    private User user;

    @GetMapping("/Login")
    public String login(){
        System.out.println("Login controller");

        return "login"; //templates 에서 시작하는 html 이름
    }
}
