package com.example.template.services;

import java.util.List;

public interface CrudOP<T> {

    public List<T> findAll();

    public T findById(Long id);

    public T save(T t);

    public void delete(Long id);

}
