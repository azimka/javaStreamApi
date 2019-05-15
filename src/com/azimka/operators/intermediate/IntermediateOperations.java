package com.azimka.operators.intermediate;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntermediateOperations {
    public Stream filterElements() {
        return Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).filter(x -> x > 5);
    }

    public Stream mapElements() {
        return Stream.of("1", "2", "3")
                .map(Integer::getInteger)
                .map(x -> x + 1);
    }

    public Stream flatMapUsage() {
        return Stream.of(1, 2, 3, 4, 5)
                .flatMap(x -> IntStream.range(0, 5).boxed());
    }

    public Stream limitUsage() {
        return Stream.of(1, 2, 3, 4, 5).limit(2);
    }

    public Stream skipUsage() {
        return IntStream.range(0, 100).skip(20).limit(10).boxed();
    }

    public Stream sortedUsage() {
        return IntStream.concat(IntStream.of(-1, 15), IntStream.rangeClosed(4, 6)).sorted().boxed();
    }

    public Stream distinctUsage() {
        return Stream.of(12, 2, 3, 4, 52, 3, 4, 1, 2, 3).distinct();
    }

    public Stream peekUsage() {
        return Stream.of(1, 2, 3, 4, 5, 6).peek(System.out::println).distinct().peek(System.out::println);
    }

    public Stream boxedUsage() {
        return IntStream.of(0, 1, 2, 3).boxed();
    }
}
