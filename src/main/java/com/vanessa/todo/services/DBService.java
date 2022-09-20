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
        Todo t2 = new Todo(null, "Ler", "Livro de desenvolvimento", LocalDateTime.parse("20/09/2022 15:33:00", formatter),true);
        Todo t3 = new Todo(null, "Exercicios", "Fazer 50 flexões", LocalDateTime.parse("01/09/2022 15:33:00", formatter),false);
        Todo t4 = new Todo(null, "Comer", "Comer a cada 3 horas", LocalDateTime.parse("15/09/2022 15:33:00", formatter),true);

        repository.saveAll(Arrays.asList(t1,t2,t3,t4));
    }
}
