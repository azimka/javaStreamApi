package com.azimka.operators.terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
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

    public void collectJoining() {
        String result = Stream.of(1, 2, 3, 4, 5, 6, 7)
                .map(String::valueOf)
                .collect(Collectors.joining(":", "----start----", "----finish----"));
        System.out.println(result);
    }

    public void collectWithSupplierAndAccumulator() {
        List<String> result = Stream.of(1, 2, 3, 4, 5, 6, 7)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public String[] toArrayUsage() {
        return Stream.of("1", "2", "3", "4")
                .toArray(String[]::new);
    }

    public Integer reduceWithIdentity() {
        return Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .reduce(10, (item, accum) -> accum + item);
    }

    public Optional<Integer> reduceEmptyAccum() {
        return Stream.of(1, 2, 3, 4, 5, 6, 7).reduce((acc, value) -> acc + value);
    }

    public Optional<Integer> minUsage() {
        return Stream.of(1, 4, 3, 2, 7, 5, 8, 9).min(Integer::compare);
    }

    public Optional<Integer> maxUsage() {
        return Stream.of(3, 6, 8, 3, 0, 9, 8, 7, 3, 2).max(Integer::compare);
    }

    public void findUsage() {

        //for parallel work quickly
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).filter(item -> item > 5).findAny();
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).filter(item -> item > 5).findFirst();
        return;
    }

    public OptionalDouble averageUsage() {
        return IntStream.range(1, 555).average();
    }

    public int sumUsage() {
        return IntStream.of(1, 2, 3, 4, 5, 6, 7, 8).sum();
    }

    public boolean allMatchUsage() {
        return Stream.of(1, 2, 3).allMatch(x -> x < 7);
    }

    public boolean anyMatchUsage() {
        return Stream.of(1, 2, 3).anyMatch(x -> x > 2);
    }

    public boolean noMatch() {
        return Stream.of(1, 2, 3).noneMatch(x -> x < 0);
    }
}
