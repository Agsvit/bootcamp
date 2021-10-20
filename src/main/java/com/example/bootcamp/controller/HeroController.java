package com.example.bootcamp.controller;

import com.example.bootcamp.model.Country;
import com.example.bootcamp.model.Hero;
import com.example.bootcamp.service.CountryService;
import com.example.bootcamp.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping
@Validated
public class HeroController {

    @Autowired
    HeroService heroService;

    @GetMapping("/getHeroes")
    public List<Hero> getHero() { return heroService.findAll();
    }
}
