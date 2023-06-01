package com.example.template.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.template.models.City;
import com.example.template.services.CrudOP;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
@RequestMapping("/api/city")
public class CityController {

    @Autowired
    private CrudOP<City> cityService;

    @GetMapping
    public List<City> getAll() {
        return this.cityService.findAll();
    }

    @GetMapping("/{id}")
    public City getOne(@PathVariable Long id) {
        return this.cityService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public City save(@RequestBody City city) {
        return this.cityService.save(city);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public City update(@RequestBody City city, @PathVariable Long id) {
        City actualCity = this.cityService.findById(id);
        actualCity.setName(city.getName());
        return this.cityService.save(actualCity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        this.cityService.delete(id);
    }

}
