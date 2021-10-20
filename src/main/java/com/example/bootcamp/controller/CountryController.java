package com.example.bootcamp.controller;


import com.example.bootcamp.model.Country;
import com.example.bootcamp.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Validated // validar informcao
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping("/getCountries")
    public List<Country> getCountry() {
        return countryService.findAll();
    }

    @GetMapping("/getCountriesId")
    public Optional<Country> getCountryId(Long countryId) {
        return countryService.findById(countryId);
    }

    @PostMapping(value = "createCountry", consumes = "application/json", produces = "application/json")
    public Country createCountry(@RequestBody Country country) {
        Country newCountry = Country.builder().name(country.getName()).build();
        countryService.save(newCountry);
        return newCountry;
    }

    @PutMapping(value = "updateCountry/{id}", consumes = "application/json", produces = "application/json")
    public Country updateCountry(Long id, @RequestBody Country country) {
        System.out.println(id);
        Optional<Country> countryToUpdate = countryService.findById(id);
        if (countryToUpdate.isPresent()) {
            countryToUpdate.get().setName(country.getName());
            countryService.save(countryToUpdate.get());
            return countryToUpdate.get();
        } else {
            ResponseEntity.badRequest().body("Country not found");
            return null;
        }
    }

    @DeleteMapping(value = "/deleteCountry/{id}")
    public void deleteCountry(Long id) {
        countryService.deleteById(id);
    }

}
