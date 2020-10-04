package com.example.todo.TodoItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TodoItemService {
    // Service: Controller와 Repository 중간에서 비즈니스 로직을 수행하는 클래스
    // Repository: DB로 쿼리를 날리는 역할

    @Autowired
    private TodoItemRepository todoItemRepository;

    public TodoItem get(final String id) {
        // do id validation
        return todoItemRepository.findById(id).orElse(null);
    }

    public TodoItem create(final TodoItem todoItem) {
        if (Objects.isNull(todoItem)) {
            throw new NullPointerException("To Do Item cannot be null.");
        }

        return todoItemRepository.insert(todoItem);
    }

    public TodoItem update(final TodoItem newItem) {
        if (Objects.isNull(newItem)) {
            throw new NullPointerException("To Do Item cannot be null.");
        }

        final TodoItem originalItem = todoItemRepository.findById(newItem.getId())
                .orElseThrow(() -> new RuntimeException("Entity Nor Found"));
        originalItem.setTitle(newItem.getTitle());
        originalItem.setDone(newItem.isDone());
        return todoItemRepository.save(originalItem);
    }

    public void delete(final String id) {
        final TodoItem todoItem = todoItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entity Nor Found"));
        todoItemRepository.delete(todoItem);
    }

    public List<TodoItem> getAll() {
        return todoItemRepository.findAll();
    }
}
