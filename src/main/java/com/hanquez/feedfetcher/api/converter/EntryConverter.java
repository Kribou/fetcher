package com.hanquez.feedfetcher.api.converter;

import com.rometools.rome.feed.synd.SyndEntry;

public interface EntryConverter<T> extends Converter<SyndEntry, T> {
}
