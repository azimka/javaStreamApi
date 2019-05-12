package com.azimka.creation;

import java.util.*;
import java.util.stream.Stream;

public class StreamCreation {
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
}
