package br.com.lteixeira.multitenant.controller;

import br.com.lteixeira.multitenant.dto.PersonDTO;
import br.com.lteixeira.multitenant.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public PersonDTO save(@RequestBody PersonDTO person) {
        return personService.save(person);
    }

    @GetMapping
    public List<PersonDTO> get() {
        return personService.findAll();
    }

}