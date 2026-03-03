package com.hasby.apitest.comments;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class CommentDataProvider {
    static Stream<Arguments> validCommentIds() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 1),
                Arguments.of(6, 2)
        );
    }

    static Stream<Arguments> invalidCommentIds() {
        return Stream.of(
                Arguments.of(999),
                Arguments.of(0),
                Arguments.of(-1)
        );
    }
}
