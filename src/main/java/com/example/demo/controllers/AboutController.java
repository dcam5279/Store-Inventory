package com.example.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {


    @GetMapping("/about")

    public String aboutPage(Model model){

    String missionStatement = "To provide top-quality lawn care products and expert service, making lawn maintenance easy, efficient, and enjoyable for every customer.";
    model.addAttribute("missionStatement",missionStatement);

    return "about";
}

}