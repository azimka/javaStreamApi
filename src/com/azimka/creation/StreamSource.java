package com.azimka.creation;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Способы создания streams
 */
public class StreamSource {
    public Stream createEmptyStream() {
        return Stream.empty();
    }

    public Stream createStreamOfCollection(Collection someCollection) {
        return someCollection.stream();
    }

    public Stream createStreamOfMap(Map someMap) {
        return someMap.entrySet().stream();
    }

    public Stream createStreamOfArray(String[] someArray) {
        return Arrays.stream(someArray);
    }

    public Stream createStreamOfElements() {
        return Stream.of("one", "two", "three");
    }

    public Stream createOfNullableStream(Object someObject) {
//        for java 9 of upper;
//        Stream.ofNullable(someObject);
        return null;
    }

    public Stream generateSupplierStream(Supplier supplier, long limitValue) {
        //Supplier - лямбда для генерации элементов
        return Stream.generate(supplier).limit(limitValue);
    }

    public Stream iterateStream() {
        //UnaryOperator
        //Stream.iterate(seed, f).limit(limitValue)
        //f(seed), f(f(seed)) ...
        return Stream.iterate(2, x -> x++).limit(10);
    }

    public Stream iterateWithHasNextStream() {
//        java >= 9
//        Predicate
//        return Stream.iterate(2, x -> x < 25, x -> x++);
        return Stream.empty();
    }

    public Stream concatStreams() {
        return Stream.concat(Stream.of(1, 2, 3), Stream.of(4, 5, 6));
    }

    public Stream.Builder<Integer> createStreamBuilder() {
        Stream.Builder<Integer> streamBuider = Stream.<Integer>builder()
                .add(0)
                .add(1);
        for (int i = 2; i <= 8; i += 2) {
            streamBuider.accept(i);
        }
        streamBuider
                .add(9)
                .add(10)
                .build()
                .forEach(System.out::println);
// 0, 1, 2, 4, 6, 8, 9, 10

        return streamBuider;
    }

    public IntStream createPrimitiveStream() {
        //exclusive
        IntStream.range(1, 10);
        LongStream.range(-10L, 10L);
        //DoubleStream

        //inclusive
        return IntStream.rangeClosed(0, 10);
    }
}
