package de.hsrm.mi.web.klausurvorbereitung.klausurvorbereitung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/fragments")
public class FragmentController {
    
    @GetMapping("/header")
    public String getHeader() {
        return "/frag/header :: header";
    }

    @GetMapping("/footer")
    public String getFooter() {
        return "/frag/footer :: footer";
    }
    

}
