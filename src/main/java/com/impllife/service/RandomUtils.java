package com.impllife.service;

import java.util.Collection;
import java.util.Random;

public class RandomUtils {
    private static final Random RANDOM = new Random();

    public static <T> T getRandomElement(Collection<T> collection) {
        int size = collection.size();
        int item = RANDOM.nextInt(size);
        int i = 0;
        for (T element : collection) {
            if (i == item) return element;
            i++;
        }
        return null;
    }
    public static <T> T getRandomElement(T[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }
        int index = RANDOM.nextInt(array.length);
        return array[index];
    }
}

