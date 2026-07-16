package io.virinchi.springwebtest1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignupLoginController {
    @GetMapping("/signup")
    public String signup(){
    return "signupPage";
    }
    @GetMapping("/login")
    public String login(){
    return "loginPage";
    }
}
