package com.hasby.apitest.todos;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class TodoDataProvider {

    static Stream<Arguments> validTodoIds() {
        return Stream.of(
                Arguments.of(1, 1, false),
                Arguments.of(2, 1, false),
                Arguments.of(4, 1, true)
        );
    }
    static Stream<Arguments> invalidTodoIds() {
        return Stream.of(
                Arguments.of(999),
                Arguments.of(0),
                Arguments.of(-1)
        );
    }
}
