package com.sifeddine.traqueur.de.coronavirus.controllers;

import com.sifeddine.traqueur.de.coronavirus.services.CoronaDataٍService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControler {
    @Autowired
    CoronaDataٍService coronaDataٍService;
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("locationStates", coronaDataٍService.getAllStats());
        return "index";
    }
}
