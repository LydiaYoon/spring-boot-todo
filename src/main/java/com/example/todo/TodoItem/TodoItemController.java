package com.example.todo.TodoItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoItemController {
    // Controller: Request를 받아서 Service에 넘겨주고 Service가 리턴한 Response를 다시 리턴하는 역할
    // URL Resolution

    @Autowired
    private TodoItemService todoItemService;

    @GetMapping(value = "/{id}")
    public @ResponseBody TodoItemResponse get(@PathVariable(value = "id") String id) {
        List<String> errors = new ArrayList<>();
        TodoItem todoItem = null;

        try {
            todoItem = todoItemService.get(id);
        } catch (final Exception e) {
            errors.add(e.getMessage());
        }

        return TodoItemAdapter.toTodoItemResponse(todoItem, errors);
    }
}
