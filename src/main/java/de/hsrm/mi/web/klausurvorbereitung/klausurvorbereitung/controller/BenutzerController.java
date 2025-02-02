package de.hsrm.mi.web.klausurvorbereitung.klausurvorbereitung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import de.hsrm.mi.web.klausurvorbereitung.ui.benutzer.BenutzerFormular;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/benutzer")
@SessionAttributes(names = {"formular", "nummer"})
public class BenutzerController {

    private final int maxwunsch = 5;
    @ModelAttribute("maxwunsch")
    public void initMaxwunsch(Model m) {
        m.addAttribute("maxwunsch", maxwunsch);
    }

    @ModelAttribute("formular")
    public void initFormular(Model m) {
        m.addAttribute("formular", new BenutzerFormular());
    }

    @GetMapping("/{nummer}")
    public String getBenutzer(@PathVariable("nummer") int nummer) {
        return "benutzerbearbeiten";
    }
    
    @PostMapping("/{nummer}")
    public String postBenutzer(@ModelAttribute("formular") BenutzerFormular formular) {
        
        return "benutzerbearbeiten";
    }
    

}
