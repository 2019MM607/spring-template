package com.example.template.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.template.models.City;

public interface ICityDao extends CrudRepository<City, Long> {

}
