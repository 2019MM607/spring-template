package com.example.template.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.template.dao.ICityDao;
import com.example.template.models.City;

@Service
public class CityService implements CrudOP<City> {

    @Autowired
    private ICityDao cityDao;

    @Override
    public List<City> findAll() {
        return (List<City>) cityDao.findAll();
    }

    @Override
    public City findById(Long id) {
        return cityDao.findById(id).orElse(null);
    }

    @Override
    public City save(City city) {
        return cityDao.save(city);
    }

    @Override
    public void delete(Long id) {
        cityDao.deleteById(id);
    }

}
