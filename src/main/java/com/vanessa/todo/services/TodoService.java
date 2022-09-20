package com.vanessa.todo.services;

import com.vanessa.todo.entities.Todo;
import com.vanessa.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public Todo findById(Long id) {
        Optional<Todo> obj = repository.findById(id);
        return obj.orElse(null);
    }
}
