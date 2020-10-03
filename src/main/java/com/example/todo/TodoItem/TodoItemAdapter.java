package com.example.todo.TodoItem;

import java.util.List;

public class TodoItemAdapter {
    // TodoItem을 TodoItemResponse로 바꿔주는 역할

    public static TodoItemResponse toTodoItemResponse(final TodoItem todoItem, final List<String> errors) {
        return TodoItemResponse.builder().todoItem(todoItem).errors(errors).build();
    }
}
