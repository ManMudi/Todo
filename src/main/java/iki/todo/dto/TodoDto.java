package iki.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TodoDto {

    private Long id;
    private String tittle;
    private String description;
    private boolean completed;
}
