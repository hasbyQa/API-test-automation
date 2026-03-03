package com.hasby.apitest.photos;

import java.util.HashMap;
import java.util.Map;

public class PhotoPayload {
    public static Map<String, Object> create(){
        Map<String, Object> photo = new HashMap<>();
        photo.put("albumId", 1);
        photo.put("title", "Test Photo Title");
        photo.put("url", "https://via.placeholder.com/600/test");
        photo.put("thumbnailUrl", "https://via.placeholder.com/150/test");
        return photo;
    }

    public static Map<String, Object> update() {
        Map<String, Object> photo = new HashMap<>();
        photo.put("albumId", 1);
        photo.put("id", 1);
        photo.put("title", "Updated Photo Title");
        photo.put("url", "https://via.placeholder.com/600/updated");
        photo.put("thumbnailUrl", "https://via.placeholder.com/150/updated");
        return photo;
    }
}
