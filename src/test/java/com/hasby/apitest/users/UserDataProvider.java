package com.hasby.apitest.users;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class UserDataProvider {
    static Stream<Arguments> validUserIds() {
        return Stream.of(
                Arguments.of(1, "Leanne Graham", "Bret"),
                Arguments.of(2, "Ervin Howell", "Antonette"),
                Arguments.of(3, "Clementine Bauch", "Samantha")
        );
    }

    static Stream<Arguments> invalidUserIds() {
        return Stream.of(
                Arguments.of(999),
                Arguments.of(0),
                Arguments.of(-1)
        );
    }
}
