package com.wildrifttracker.domain.utils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public abstract class DataPreparer {
    public static <M, D> D sanitizeUniqueData(Function<M, D> genericDto, M genericData) {
        return genericDto.apply(genericData);
    }

    public static <M, D> List<D> sanitizeListData(Function<M, D> genericDto, List<M> genericData) {
        Stream<M> genericDataStream = genericData.stream();
        return genericDataStream.map(genericDto).toList();
    }
}
