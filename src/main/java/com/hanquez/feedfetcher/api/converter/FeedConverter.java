package com.hanquez.feedfetcher.api.converter;

import com.rometools.rome.feed.synd.SyndFeed;

public interface FeedConverter<T> extends Converter<SyndFeed, T> {
}
