package com.example.todo.TodoItem;

import com.example.todo.Api.ApiResponse;
import lombok.Builder;

import java.util.List;

public class TodoItemResponse extends ApiResponse<TodoItem> {

    @Builder
    public TodoItemResponse(final TodoItem todoItem, final List<String> errors) {
        super(todoItem);
        this.setErrors(errors);
    }
}
