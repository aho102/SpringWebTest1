package io.virinchi.springwebtest1.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GalleryController {

    @GetMapping("/gallery")
    public String galleryGet(){
        return "galleryPage.html";
    }
}
