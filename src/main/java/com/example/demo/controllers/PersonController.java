package com.example.demo.controllers;

import com.example.demo.entities.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//http://localhost:7070/person/all

@Controller
@RequestMapping("/person")
public class PersonController {

    private PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

//    returns a template named "all" from templates;
    @GetMapping("/all")
    public String all(Model model) {
//        Adding to our thymeLeaf *MODEL* atr named - "all" with the returned Object from repository.findAll inside,
//        So we can put it into our  thymeleaf html Template - *All*
        model.addAttribute("all", repository.findAll());
        return "person/all";
    }
}
