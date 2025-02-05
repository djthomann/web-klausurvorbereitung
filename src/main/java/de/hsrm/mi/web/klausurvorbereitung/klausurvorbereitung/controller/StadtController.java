package de.hsrm.mi.web.klausurvorbereitung.klausurvorbereitung.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import de.hsrm.mi.web.klausurvorbereitung.klausurvorbereitung.entitities.stadt.Stadt;
import de.hsrm.mi.web.klausurvorbereitung.klausurvorbereitung.services.stadt.StadtService;
import de.hsrm.mi.web.klausurvorbereitung.ui.stadt.StadtFormular;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("stadt")
@SessionAttributes(names = {"stadtformular"})
public class StadtController {
    
    Logger logger = LoggerFactory.getLogger(StadtController.class);

    @Autowired
    StadtService stadtService;

    @ModelAttribute("stadtformular")
    public void initFormular(Model m) {
        m.addAttribute("stadtformular", new StadtFormular());
    }

    @GetMapping("")
    public String getStadt() {
        return "redirect:stadt/0";
    }
    

    @GetMapping("/{nummer}")
    public String getStadtAnlegen(@ModelAttribute("stadtformular") StadtFormular formular, @PathVariable("nummer") int nummer) {
        logger.info("Stadt anlegen abgerufen");
        logger.info(formular.toString());
        if(nummer == 0) {
            // Neue Stadt anlegen
        } else {
            // Bestehende Stadt holen
            Optional<Stadt> s = stadtService.holeStadtMitId(nummer);
            if(s.isPresent()) {
                formular.fromStadt(s.get());
            }
        }
        return "stadtanlegen";
    }

    @PostMapping("/{nummer}")
    public String postStadt(@Valid @ModelAttribute("stadtformular") StadtFormular formular, @PathVariable("nummer") int nummer) {
        if(nummer == 0) {
            // Neue Stadt anlegen
            Stadt s = new Stadt();
            formular.toStadt(s);
            stadtService.speichereStadt(s);
        } else {
            // Bestehende Stadt anpassen
            Optional<Stadt> s = stadtService.holeStadtMitId(nummer);
            if(s.isPresent()) {
                stadtService.speichereStadt(s.get());
            }
        }
        return "stadtanlegen";
    }
    
    

}
