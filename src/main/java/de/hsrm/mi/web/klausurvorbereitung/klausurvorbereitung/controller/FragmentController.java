package de.hsrm.mi.web.klausurvorbereitung.klausurvorbereitung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/hx/fragments")
public class FragmentController {
   
    @GetMapping("/schnipsel/{name}/{nummer}")
    public String getMethodName(@PathVariable("name") String name, @PathVariable("nummer") int nummer) {
        return "/frag/schnipsel :: schnipsel";
    }
    

    @GetMapping("/header")
    public String getHeader() {
        return "/frag/header :: header";
    }

    @GetMapping("/footer")
    public String getFooter() {
        return "/frag/footer :: footer";
    }
    

}
