package com.hasby.apitest.posts;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class PostDataProvider {
    static Stream<Arguments> validPostIds() {
        return Stream.of(
                Arguments.of(1, 1, "sunt aut facere"),
                Arguments.of(2, 1, "qui est esse"),
                Arguments.of(3, 1, "ea molestias quasi")
        );
    }
        static Stream<Arguments> invalidPostIds(){
            return Stream.of(
                    Arguments.of(999),
                    Arguments.of(0),
                    Arguments.of(-1)
            );
    }
}
