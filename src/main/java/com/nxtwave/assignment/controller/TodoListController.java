package com.nxtwave.assignment.controller;

import com.nxtwave.assignment.dto.TodoDto;
import com.nxtwave.assignment.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoListController {
    @Autowired
    private TodoService todoService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TodoDto>> getAllTodos() {
        return ResponseEntity.ok().body(todoService.getAllTodos());
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<TodoDto> getTodoById(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(todoService.getTodoById(id));

    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<TodoDto> saveTodo(@RequestBody TodoDto todoDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.saveToDo(todoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodoById(@PathVariable("id") int id) {
        todoService.deleteTodoById(id);
        return ResponseEntity.status(HttpStatus.OK).body(id + " id record deleted");
    }

    @PutMapping(value = ("/{id}"), produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<TodoDto> updateTodoById(@PathVariable("id") int id, @RequestBody TodoDto todoDto) {
        TodoDto upatedTodoDto = todoService.updateTodoStatusById(id, todoDto);
        return ResponseEntity.status(HttpStatus.OK).body(upatedTodoDto);
    }
}
