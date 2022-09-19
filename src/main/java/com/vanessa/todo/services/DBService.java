package com.vanessa.todo.services;

import com.vanessa.todo.entities.Todo;
import com.vanessa.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private TodoRepository repository;

    public void instanciaBaseDados(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        Todo t1 = new Todo(null, "Estudar", "Estudar springboot 2 e Angular 11", LocalDateTime.parse("19/09/2022 15:33:00", formatter),false);

        repository.saveAll(Arrays.asList(t1));
    }
}
