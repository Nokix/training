package com.example.training.model;

import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface Creator<T> {
    T create();

    default Collection<T> createMultiple(int n) {
        return IntStream.range(0,n)
                .mapToObj(i -> create())
                .collect(Collectors.toList());
    }

    default Collection<T> createRandomAmount(int minInclusive, int maxExclusive) {
        int n = new Random().nextInt(minInclusive, maxExclusive);
        return createMultiple(n);
    }
}
