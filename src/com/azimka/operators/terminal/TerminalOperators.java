package com.azimka.operators.terminal;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TerminalOperators {
    public void forEachOperator() {
        IntStream.range(0, 10000)
                .parallel()
                .filter(x -> x % 1000 == 0)
                .forEach(System.out::println);
    }

    public void forEachOrdered() {
        IntStream.range(0, 10000)
                .parallel()
                .filter(x -> x % 1000 == 0)
                .forEachOrdered(System.out::println);
    }

    public long countOperator() {
        return Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .count();
    }
}
