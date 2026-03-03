package com.hasby.apitest.albums;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class AlbumDataProvider {
    static Stream<Arguments> validAlbumIds() {
        return Stream.of(
                Arguments.of(1, 1, "quidem molestiae enim"),
                Arguments.of(2, 1, "sunt qui excepturi"),
                Arguments.of(3, 1, "omnis laborum odio")
        );
    }

    static Stream<Arguments> invalidAlbumIds() {
        return Stream.of(
                Arguments.of(999),
                Arguments.of(0),
                Arguments.of(-1)
        );
    }
}
