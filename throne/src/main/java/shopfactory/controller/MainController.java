package shopfactory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value={"","/"})
    public String main(){
        System.out.println("maincontroller");

        return "index"; //templates 에서 시작하는 html 이름
    }
}
