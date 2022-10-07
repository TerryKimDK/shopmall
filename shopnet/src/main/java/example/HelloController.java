package example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping ("/")
    public String Hello(){
        System.out.println("Hello");
        return "Hello";
        //templates 에서 시작하는 html 이름
    }
}
