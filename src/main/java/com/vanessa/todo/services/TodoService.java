package com.vanessa.todo.services;

import com.vanessa.todo.entities.Todo;
import com.vanessa.todo.repositories.TodoRepository;
import com.vanessa.todo.services.exceptions.ObjectNotFoundException;
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
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: "+ Todo.class.getName()));
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
    public Todo create(Todo obj) {
        obj.setId(null);
        return repository.save(obj);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Todo update(Long id, Todo obj) {
        Todo newObj = findById(id);
        newObj.setTitulo(obj.getTitulo());
        newObj.setDataParaFinalizar(obj.getDataParaFinalizar());
        newObj.setDesccricao(obj.getDesccricao());
        newObj.setFinalizado(obj.getFinalizado());
        return repository.save(newObj);
    }
}
