package com.example.todo.Api;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public abstract class ApiResponse<T> {
    // http response에 포함되어 브라우저로 전달 될 모델
    // Model 그대로 브라우저에 전달하는 것은 비즈니스 로직을 공개하는 것이므로 Response 클래스로 감싸주는 것이 좋다.
    // Response에는 에러 메시지 등이 들어가야 하므로 항상 Model과 같지는 않다.

    @NonNull private T data;
    private List<String> errors;
}
