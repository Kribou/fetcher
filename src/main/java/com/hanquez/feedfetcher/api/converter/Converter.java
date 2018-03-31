package com.hanquez.feedfetcher.api.converter;

/**
 * A converter from D type object to C type object
 * @param <D> type of the Data object to be converted
 * @param <C> type of the Converted object
 */
public interface Converter<D, C> {

    C convert(D data);
}
