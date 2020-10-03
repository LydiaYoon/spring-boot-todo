package com.example.todo.TodoItem;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoItem {
    @Id
    private String id;
    private String title;
    private boolean done;
}
