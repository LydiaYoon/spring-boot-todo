package com.example.todo.TodoItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class TodoItemAdapter {

    // TodoItemRequest -> TodoItem
    public static TodoItem toTodoItem(final TodoItemRequest todoItemRequest) {
        if (Objects.isNull(todoItemRequest)) {
            return null;
        }

        return TodoItem.builder()
                .id(todoItemRequest.getId())
                .title(todoItemRequest.getTitle())
                .done(todoItemRequest.isDone())
                .build();
    }

    // TodoItem -> TodoItemResponse
    public static TodoItemResponse toTodoItemResponse(final TodoItem todoItem, final List<String> errors) {
        return TodoItemResponse.builder()
                .todoItem(todoItem)
                .errors(Optional.ofNullable(errors).orElse(new ArrayList<>()))
                .build();
    }
}
