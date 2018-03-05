package com.hanquez.feedfetcher.impl.converter;

import com.hanquez.feedfetcher.api.converter.FeedConverter;
import com.rometools.rome.feed.synd.SyndFeed;

public class SyndFeedConverter implements FeedConverter<SyndFeed> {

    @Override
    public SyndFeed convert(SyndFeed feed) {
        return feed;
    }
}
