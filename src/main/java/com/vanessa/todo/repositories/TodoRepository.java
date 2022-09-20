package com.vanessa.todo.repositories;

import com.vanessa.todo.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    @Query("select obj FROM Todo obj WHERE obj.finalizado = false order by obj.dataParaFinalizar")
    List<Todo> findAllOpen();
    @Query("select obj from Todo obj where obj.finalizado = true order by obj.dataParaFinalizar")
    List<Todo> findAllClosed();
}
