package com.example.template.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.template.models.City;
import com.example.template.models.Cliente;
import com.example.template.services.CrudOP;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH,
        RequestMethod.DELETE })
@RequestMapping("/api/clients")
public class ClienteController {

    @Autowired
    private CrudOP<Cliente> clienteService;

    @GetMapping
    public List<Cliente> getAll() {
        return this.clienteService.findAll();
    }

    @GetMapping("/{id}")
    public Cliente getOne(@PathVariable Long id) {
        return this.clienteService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Cliente save(@RequestBody Cliente cliente) {
        return this.clienteService.save(cliente);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id) {
        Cliente clienteActual = this.clienteService.findById(id);
        clienteActual.setName(cliente.getName());
        clienteActual.setApelido(cliente.getApelido());
        clienteActual.setEmail(cliente.getEmail());
        clienteActual.setCity(cliente.getCity());
        return this.clienteService.save(clienteActual);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        this.clienteService.delete(id);
    }

}
