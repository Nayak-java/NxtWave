package com.nxtwave.assignment.service;

import com.nxtwave.assignment.dto.TodoDto;
import com.nxtwave.assignment.entities.Todo;
import com.nxtwave.assignment.exception.TodoNotFoundException;
import com.nxtwave.assignment.respository.TodoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoJpaRepository jpaRepository;

    @Override
    public List<TodoDto> getAllTodos() {
        return jpaRepository.findAll().stream()
                .map(TodoServiceImpl::mapTodoDtoFromTodo).collect(Collectors.toList());

    }

    @Override
    public TodoDto getTodoById(int id) {
        Todo todo = jpaRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException("to do des not exists", id));
        return mapTodoDtoFromTodo(todo);
    }

    @Override
    public TodoDto saveToDo(TodoDto todoDto) {
        Todo todoEntity = mapTodoFromTodoDto(todoDto);
        Todo todo = jpaRepository.save(todoEntity);
        return mapTodoDtoFromTodo(todo);
    }

    @Override
    public void deleteTodoById(int id) {
        Todo todo = jpaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        jpaRepository.delete(todo);

    }

    @Override
    public TodoDto updateTodoStatusById(int id, TodoDto todoDto) {
        Todo todoEntity = jpaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        todoEntity.setStatus(todoDto.getStatus());

        Todo todo = jpaRepository.save(todoEntity);

        return mapTodoDtoFromTodo(todo);
    }


    public static TodoDto mapTodoDtoFromTodo(Todo todo) {
        return TodoDto.of()
                .id(todo.getId())
                .todo(todo.getTodo())
                .status(todo.getStatus())
                .priority(todo.getPriority())
                .build();
    }

    public static Todo mapTodoFromTodoDto(TodoDto todoDto) {
        return Todo.of()
                .id(todoDto.getId())
                .todo(todoDto.getTodo())
                .status(todoDto.getStatus())
                .priority(todoDto.getPriority())
                .build();
    }
}
