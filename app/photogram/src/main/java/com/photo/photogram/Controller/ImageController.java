package com.photo.photogram.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImageController {
    @GetMapping({"/", "/image/story"})
    public String story() {
        return "image/story";
    }

    @GetMapping("/image/upload")
    public String upload() {
        return "image/upload";
    }

    @GetMapping("/image/popular")
    public String popularPage() {
        return "image/popular";
    }


}
