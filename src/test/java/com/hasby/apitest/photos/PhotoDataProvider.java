package com.hasby.apitest.photos;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class PhotoDataProvider {
    static Stream<Arguments> validPhotoIds() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 1),
                Arguments.of(51, 2)
        );
    }

    static Stream<Arguments> invalidPhotoIds() {
        return Stream.of(
                Arguments.of(99999),
                Arguments.of(0),
                Arguments.of(-1)
        );
    }
}
