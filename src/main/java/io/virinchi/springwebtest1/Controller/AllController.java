package io.virinchi.springwebtest1.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//controller msanage http request: get  mapping and post mapping , etc // helps get and post mapping
public class AllController {

    @GetMapping("/")
public String firstPage(){ //function name can be anything
    return "firstPage.html";
}
}
