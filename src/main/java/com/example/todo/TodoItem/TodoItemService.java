package com.example.todo.TodoItem;

import org.springframework.stereotype.Service;

@Service
public class TodoItemService {
    // Service: Controller와 Repository 중간에서 비즈니스 로직을 수행하는 클래스
    // Repository: DB로 쿼리를 날리는 역할

    public TodoItem get(final String id) {
        // do id validation
        return TodoItem.builder()
                .title("Add an id validation")
                .build();
    }
}
