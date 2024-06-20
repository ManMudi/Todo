package iki.todo.controller;

import iki.todo.dto.TodoDto;
import iki.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/todo")
@AllArgsConstructor
public class TodoController {

    private TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto){
        TodoDto todoDto1=todoService.addTodo(todoDto);
        return new ResponseEntity<>(todoDto1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TodoDto>> listResponseEntity(){
        List<TodoDto>todoDto=todoService.getAllTodo();
        return ResponseEntity.ok(todoDto);
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoDto> todoDtoResponseEntity(@PathVariable Long id){
        TodoDto todoDto=todoService.findById(id);
        return ResponseEntity.ok(todoDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<TodoDto> response(@PathVariable Long id,@RequestBody TodoDto todoDto){
        TodoDto todoDto1=todoService.updateTodo(id,todoDto);
        return ResponseEntity.ok(todoDto1);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> response(@PathVariable Long id){
        todoService.deleteTodo(id);
        return ResponseEntity.ok("Deleted Successfully !");
    }

    @PatchMapping("{id}/complete")
    public  ResponseEntity<TodoDto> responseEntity(@PathVariable Long id){
        TodoDto todoDto=todoService.completed(id);
        return ResponseEntity.ok(todoDto);
    }

    @PatchMapping("{id}/in-complete")
    public ResponseEntity<TodoDto> dtoResponseEntity(@PathVariable Long id){
        TodoDto todoDto=todoService.incomplete(id);
        return ResponseEntity.ok(todoDto);
    }
}
