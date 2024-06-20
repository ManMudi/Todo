package iki.todo.mapper;

import iki.todo.dto.TodoDto;
import iki.todo.entity.Todo;

public class TodoMapper {

    public static Todo mapTodo(TodoDto todoDto){
        Todo todo=new Todo();
        todo.setId((todo.getId()));
        todo.setTittle(todoDto.getTittle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());
        return todo;
    }

    public static TodoDto mapTodoDto(Todo todo){
        TodoDto todoDto=new TodoDto();
        todoDto.setId(todo.getId());
        todoDto.setTittle(todo.getTittle());
        todoDto.setDescription(todo.getDescription());
        todoDto.setCompleted(todoDto.isCompleted());
        return todoDto;
    }
}
