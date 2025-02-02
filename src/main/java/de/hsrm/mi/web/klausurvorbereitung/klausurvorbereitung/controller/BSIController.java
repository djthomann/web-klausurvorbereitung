package de.hsrm.mi.web.klausurvorbereitung.klausurvorbereitung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/bsi")
public class BSIController {
    
    @GetMapping("")
    public String getBSI() {
        return "bsi";
    }

    @PostMapping("")
    public String postBSI(Model m, int koerpergroesse, int schuhgroesse, int semester) {
        
        float bsi = 100 * (float)koerpergroesse / (semester * schuhgroesse);
        m.addAttribute("bsiwert", bsi);
        return "bsi";
    }
    
    

}
