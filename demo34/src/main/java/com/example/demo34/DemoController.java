package com.example.demo34;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DemoController {

    private final PersonRepo personRepo;


    public DemoController(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @GetMapping("/index/{first}")
    public String index(Model model, @PathVariable("first") String name) {
        model.addAttribute("name", name.toUpperCase());

        return "index";
    }

    @GetMapping("/listPerson")
    public String listperson(Model model) {
        model.addAttribute("people", personRepo.findAll());
        return "listPerson";

    }

    @GetMapping("/addperson")
    public String addPersonForm() {
        return "addperson";
    }

    @PostMapping("/add")
    public String addPerson(@ModelAttribute("person") Person person) {
        personRepo.save(person);
        return "redirect:/listPerson";


    }


}
