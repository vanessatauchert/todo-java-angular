package com.vanessa.todo.services;

import com.vanessa.todo.entities.Todo;
import com.vanessa.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public Todo findById(Long id) {
        Optional<Todo> obj = repository.findById(id);
        return obj.orElse(null);
    }

    public List<Todo> findAllOpen() {
        List<Todo> list = repository.findAllOpen();
        return list;
    }
    public List<Todo> findAllClosed() {
        List<Todo> list = repository.findAllClosed();
        return list;
    }
    public List<Todo> findAll() {
        List<Todo> list = repository.findAll();
        return list;
    }
}
