package com.example.registrationLoginSecurityThymeleaf.web;

import com.example.registrationLoginSecurityThymeleaf.Model.Weight;
import com.example.registrationLoginSecurityThymeleaf.Service.WeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class WeightController {

    @Autowired
    private WeightService service;

/*
   @GetMapping("/index")
    public String viewHomePage(Model model) {
        List<Weight> listweight = service.listAll();
        model.addAttribute(" listweight",  listweight);
        System.out.print("Get / ");
        return "data";
    }
 */





    @GetMapping("/index")
    public String add(Model model){
       model.addAttribute("weight",new Weight());
       return  "index";

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("weight") Weight weight) {
        service.save(weight);
        return "redirect:/";
    }

    /*
----EKLEMEDİM
    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Student> liststudent = service.listAll();
        model.addAttribute("liststudent", liststudent);
        System.out.print("Get / ");
        return "index";
    }

    -EKLEDIM
    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("student", new Student());
        return "new";
    }
  -Ekledim
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student std) {
        service.save(std);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        Student std = service.get(id);
        mav.addObject("student", std);
        return mav;

    }

    @RequestMapping("/delete/{id}")
    public String deletestudent(@PathVariable(name = "id") int id, RedirectAttributes attributes) {
        service.delete(id);
        attributes.addFlashAttribute("success","The student has deleted !");
        return "redirect:/";
    }

     */
}
