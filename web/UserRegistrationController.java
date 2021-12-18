package com.example.registrationLoginSecurityThymeleaf.web;


import com.example.registrationLoginSecurityThymeleaf.Model.User;
import com.example.registrationLoginSecurityThymeleaf.Service.UserService;
import com.example.registrationLoginSecurityThymeleaf.web.dto.UserRegistrationDto;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private UserService userService;

    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }

    @GetMapping
    public  String showRegistrationForm(){
        return  "registration";
    }

    @PostMapping()
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
        userService.save(registrationDto);
       // return  new ModelAndView("redirect:/index");
        return "index";
 //exception ekle
    }
}