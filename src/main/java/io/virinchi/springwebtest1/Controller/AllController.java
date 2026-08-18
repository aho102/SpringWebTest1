package io.virinchi.springwebtest1.Controller;



import io.virinchi.springwebtest1.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//controller msanage http request: get  mapping and post mapping , etc // helps get and post mapping
public class AllController {

    @Autowired
    private UserRepository uRepo;

    @GetMapping("/")
public String firstPage(){ //function name can be anything
    return "firstPage.html";
}

@GetMapping("/home")
public String homeGet(Model m)
{
    m.addAttribute("totalUsers",uRepo.findAll() );

    return "home.html";

}
}
