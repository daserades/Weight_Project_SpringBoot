package com.example.registrationLoginSecurityThymeleaf.web;

import com.example.registrationLoginSecurityThymeleaf.Model.User;
import com.example.registrationLoginSecurityThymeleaf.Model.Weight;
import com.example.registrationLoginSecurityThymeleaf.Service.UserService;
import com.example.registrationLoginSecurityThymeleaf.Service.WeightService;
import com.example.registrationLoginSecurityThymeleaf.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {


    @Autowired
    private WeightService service;

    @GetMapping("/login")
    public  String login(){
        return "login";
    }

   @GetMapping("/")
    public String home() {
        return "index";
    }


    @GetMapping("/data")
    public String data() {
        return "data";
    }

    @RequestMapping("/motivation")
    public String getMotivationPage() {
        return "motivation";
    }
    @RequestMapping("/data")
    public String getDataPage() {
        return "data";
    }
    @RequestMapping("/settings")
    public String getSettingsPage() {
        return "settings";
    }

  /*
    */
}
