package com.codegym.testmd4c12.controller;


import com.codegym.testmd4c12.model.City;
import com.codegym.testmd4c12.model.Country;
import com.codegym.testmd4c12.repository.ICountryRepository;
import com.codegym.testmd4c12.service.city.ICityService;
import com.codegym.testmd4c12.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private ICountryService countryService;
    @Autowired
    private ICityService cityService;

    @ModelAttribute("countries")
    public Iterable<Country>findAllCountry(){
        return countryService.findAll();
    }
    @GetMapping
    public ResponseEntity<Iterable<City>> listCity() {
        return new ResponseEntity<>(cityService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> cityDetail(@PathVariable Long id) {
        return new ResponseEntity<>(cityService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<City> createNewCity(@RequestBody City city) {
        return new ResponseEntity<>(cityService.save(city), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<City> deleteCity(@PathVariable Long id){
       Optional<City> city = cityService.findById(id);
        if (city.isPresent()){
            cityService.remove(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<City>editCity(@PathVariable Long id ,@RequestBody City city){
        Optional<City> city1 = cityService.findById(id);
        city.setId(city1.get().getId());
        if (city1.isPresent()){
            cityService.save(city);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
