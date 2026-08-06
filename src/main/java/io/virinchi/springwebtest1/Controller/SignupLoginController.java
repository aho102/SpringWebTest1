package io.virinchi.springwebtest1.Controller;

import io.virinchi.springwebtest1.Model.UserTbl;
import io.virinchi.springwebtest1.Repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupLoginController {
    @Autowired // only necessary function are taken and hides unwanted function
    private UserRepository uRepo; // making object of UserRepository(interface) // this object is use for database
    @GetMapping("/signup")
    public String signup() {
        return "signupPage";
    }

    @GetMapping("/login")
    public String login() {
        return "loginPage";
    }

    //the data is comming from signupPage.html taking 2 data username and password
    @PostMapping("/signup")
    public String signupPost(HttpServletRequest request) {
        //request.getParameter("username") name? -> Intellij -> form name
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserTbl user = new UserTbl();
        user.setUsername(username);
        user.setPassword(password);

        uRepo.save(user);
        // save -> curd relation
        //one row at a time


        return "loginPage";
    }

    @PostMapping("/login")
    public String LoginPost(){
        return "home";
    }
}
