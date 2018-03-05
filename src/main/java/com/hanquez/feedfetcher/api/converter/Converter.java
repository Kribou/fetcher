package com.hanquez.feedfetcher.api.converter;

public interface Converter<DATA, CONVERTEDDATA> {

    CONVERTEDDATA convert(DATA data);
}
