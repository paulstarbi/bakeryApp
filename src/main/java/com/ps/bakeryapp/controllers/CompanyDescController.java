package com.ps.bakeryapp.controllers;

import com.ps.bakeryapp.services.DescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompanyDescController {

    private DescriptionService descriptionService;

    @Autowired
    public CompanyDescController(DescriptionService descriptionService) {
        this.descriptionService = descriptionService;
    }

    @GetMapping("/ofirmie")
    public String companyDescriptionSite(Model model) {

        model.addAttribute("description", descriptionService.findDescriptionById(1L));

        return "companyDesc";
    }



}
