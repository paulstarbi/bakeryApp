package com.ps.bakeryapp.controllers;

import com.ps.bakeryapp.models.Description;
import com.ps.bakeryapp.services.DescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {

    @GetMapping("/kontakt")
    public String contactPage(Model model) {

        return "contact";
    }
}
