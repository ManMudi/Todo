package iki.todo.service;

import iki.todo.dto.TodoDto;

import java.util.List;

public interface TodoService {

    TodoDto addTodo(TodoDto todoDto);
    List<TodoDto> getAllTodo();
    TodoDto findById(Long id);
    TodoDto updateTodo(Long id,TodoDto todoDto);
    void deleteTodo(Long id);
    TodoDto completed(Long id);
    TodoDto incomplete(Long id);
}
