package com.example.demo.controllers;

import com.example.demo.entities.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
/*
      http://localhost:7070/person
      http://localhost:7070/person/all
      http://localhost:7070/person/create
      http://localhost:7070/person/createHandler
*/
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

    @GetMapping("/create")
    public String create() {
        return "person/create";
    }

    @PostMapping("/createHandler")
    public String createHandler(HttpServletRequest request, Model model) {
//        *** request.getParameter Is Always returns String so we have to parse it to int:
        String fn = request.getParameter("fn");
        String ln = request.getParameter("ln");
        int age = Integer.parseInt(request.getParameter("age"));

        Person afterSave = repository.save(
                new Person(fn,ln,age)
        );
        model.addAttribute(
                "greetingsMsg", "Hello " + afterSave.getFirstName()
                        + "- " + afterSave.getLastName()
                        + "! your age is: " + afterSave.getAge()
                        + " and your id is " + afterSave.getId());
        return "person/greetings";
    }


}
