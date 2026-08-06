package io.virinchi.springwebtest1.Controller;

import io.virinchi.springwebtest1.Model.UserTbl;
import io.virinchi.springwebtest1.Repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Base64;

@Controller
public class SignupLoginController {
    @Autowired
    // only necessary function are taken and hides unwanted function
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

        // post mapping of signup ma yesko kaam bhairako xa
        String hashPassword = DigestUtils.md5DigestAsHex(password.getBytes());
        //md5 algorithn, this is basic algorithm anyone can hack it
        //we will learn decrypt technique very soon

        UserTbl user = new UserTbl();
        user.setUsername(username);
        user.setPassword(hashPassword);

        uRepo.save(user);
        // save -> curd relation
        //one row at a time


        return "loginPage";
    }

    @PostMapping("/login")
    public String LoginPost(HttpServletRequest request, Model m)
    {
      String username = request.getParameter("username");
      String password = request.getParameter("password");

      String hashPassword = DigestUtils.md5DigestAsHex(password.getBytes());

     if (uRepo.existsByUsernameAndPassword(username,hashPassword)){
        return "home";
     }

     //messsage pathauna kunai page ma hamlai model haixa
        // //model ma attribute rakhey ra pathau xaum
        //controlller bata html page ma model ley message transfer garxa

        //m.addAttribute("title","msg");
        m.addAttribute("error","Username or password is incorrect");

        return "loginPage";
    }
}
