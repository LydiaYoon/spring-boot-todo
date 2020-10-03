package com.example.todo.TodoItem;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoItemRepository extends MongoRepository<TodoItem, String> {
    // MongoRepository<Model, ID>
    // Model: 이 Repository가 표현해야 하는 모델
    // ID: Model을 구별할 수 있는 ID의 타입
}
