package com.nxtwave.assignment.service;

import com.nxtwave.assignment.dto.TodoDto;
import com.nxtwave.assignment.entities.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TodoService {
    List<TodoDto> getAllTodos();
    TodoDto getTodoById(int id);
    TodoDto saveToDo(TodoDto todoDto);
    void deleteTodoById(int id);
    TodoDto updateTodoStatusById(int id , TodoDto todoDto);

}
