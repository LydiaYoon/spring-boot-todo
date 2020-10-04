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

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public @ResponseBody
    TodoItemResponse get(@PathVariable(value = "id") String id) {
        List<String> errors = new ArrayList<>();
        TodoItem todoItem = null;

        try {
            todoItem = todoItemService.get(id);
        } catch (final Exception e) {
            errors.add(e.getMessage());
            e.printStackTrace();
        }

        return TodoItemAdapter.toTodoItemResponse(todoItem, errors);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<TodoItemResponse> getAll() {
        List<String> errors = new ArrayList<>();
        List<TodoItem> todoItems = todoItemService.getAll();
        List<TodoItemResponse> todoItemResponses = new ArrayList<>();

        todoItems.forEach(todoItem -> {
            todoItemResponses.add(TodoItemAdapter.toTodoItemResponse(todoItem, errors));
        });

        return todoItemResponses;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    TodoItemResponse create(@RequestBody final TodoItemRequest todoItemRequest) {
        List<String> errors = new ArrayList<>();
        TodoItem todoItem = TodoItemAdapter.toTodoItem(todoItemRequest);

        try {
            todoItem = todoItemService.create(todoItem);
        } catch (final Exception e) {
            errors.add(e.getMessage());
            e.printStackTrace();
        }

        return TodoItemAdapter.toTodoItemResponse(todoItem, errors);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody
    TodoItemResponse update(@RequestBody final TodoItemRequest todoItemRequest) {
        List<String> errors = new ArrayList<>();
        TodoItem todoItem = TodoItemAdapter.toTodoItem(todoItemRequest);

        try {
            todoItem = todoItemService.update(todoItem);
        } catch (final Exception e) {
            errors.add(e.getMessage());
            e.printStackTrace();
        }
        return TodoItemAdapter.toTodoItemResponse(todoItem, errors);
    }
}
