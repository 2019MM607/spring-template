package com.example.template.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.template.models.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long> {

}
