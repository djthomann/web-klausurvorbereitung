package de.hsrm.mi.web.klausurvorbereitung.klausurvorbereitung.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("glueck")
public class GlueckController {
 
    @GetMapping("")
    @ResponseBody
    public int getGlueck() {
        Random r = new Random();
        return r.nextInt(1, 17);
    }
    

}
