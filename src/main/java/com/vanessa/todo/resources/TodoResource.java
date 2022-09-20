package com.vanessa.todo.resources;

import com.vanessa.todo.entities.Todo;
import com.vanessa.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/todos")
public class TodoResource {

    @Autowired
    private TodoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Todo> findById(@PathVariable Long id){
        Todo obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping(value = "/open")
    public ResponseEntity<List<Todo>> listOpen() {
        List<Todo> list = service.findAllOpen();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/closed")
    public ResponseEntity<List<Todo>> listClosed() {
        List<Todo> list = service.findAllClosed();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping
    public ResponseEntity<List<Todo>> listAll() {
        List<Todo> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
