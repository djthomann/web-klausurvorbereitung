package de.hsrm.mi.web.klausurvorbereitung.klausurvorbereitung.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

// Wenig sinnvoll da keine Ausgabe des Stacktrace, aber nett zum Ausprobieren
// @Controller
// @ControllerAdvice
public class KrassungsController implements ErrorController {

    public static final String ERRORPATH = "/error";
    
    @RequestMapping(ERRORPATH)
    public String handleError(HttpServletRequest request, Model model) {
        var code = request.getAttribute("javax.servlet.error.status_code");
        model.addAttribute("info", "Krass! HTTP Fehlercode "+code);
        return "error";
    }


}
