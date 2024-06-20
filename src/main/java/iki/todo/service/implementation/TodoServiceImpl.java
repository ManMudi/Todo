package iki.todo.service.implementation;

import iki.todo.dto.TodoDto;
import iki.todo.entity.Todo;
import iki.todo.exception.ResourceNotFoundException;
import iki.todo.mapper.TodoMapper;
import iki.todo.repository.TodoRepository;
import iki.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {
        Todo todo= TodoMapper.mapTodo(todoDto);
        Todo savedTodo=todoRepository.save(todo);
        return TodoMapper.mapTodoDto(savedTodo);
    }

    @Override
    public List<TodoDto> getAllTodo() {
        List<Todo> todoList=todoRepository.findAll();
        return todoList.stream().map(TodoMapper::mapTodoDto)
                .collect(Collectors.toList());
    }

    @Override
    public TodoDto findById(Long id) {
        Todo todo=todoRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("To do  Is Not Found"));
        return TodoMapper.mapTodoDto(todo);
    }

    @Override
    public TodoDto updateTodo(Long id, TodoDto todoDto) {
        Todo todo=todoRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("To do  Is Not Found"));
        todo.setTittle(todoDto.getTittle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());
        Todo todo1=todoRepository.save(todo);
        return TodoMapper.mapTodoDto(todo1);
    }

    @Override
    public void deleteTodo(Long id) {
        Todo todo=todoRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("To do  Is Not Found"));
        todoRepository.delete(todo);
    }

    @Override
    public TodoDto completed(Long id) {
        Todo todo=todoRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("To do  Is Not Found"));
        todo.setCompleted(Boolean.TRUE);
        Todo todo1=todoRepository.save(todo);
        return TodoMapper.mapTodoDto(todo1);
    }

    @Override
    public TodoDto incomplete(Long id) {
        Todo todo=todoRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("To do  Is Not Found"));
        todo.setCompleted(Boolean.FALSE);
        Todo todo1=todoRepository.save(todo);
        return TodoMapper.mapTodoDto(todo1);
    }
}
