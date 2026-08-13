package io.virinchi.springwebtest1.Controller;

import io.virinchi.springwebtest1.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserRepository uRepo; // no need to use new keyword also known as dependency


    @PostMapping("/deleteUser")
     public String  deletePost(@RequestParam("id") int id, Model m){
    //int id = req.getParameter("id");  // req.getParameter ley string value falxa yesma pheri change gari rakhnu parxa
        uRepo.deleteById(id);
        m.addAttribute("totalUsers",uRepo.findAll());
        return "home";
    }

}
