package com.hanquez.feedfetcher.api.fetcher;

import com.hanquez.feedfetcher.api.converter.FeedConverter;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import java.io.IOException;
import java.net.URL;

public class FeedFetcher {

    public static SyndFeed getFeed(String url) throws IOException, FeedException {
        URL feedUrl = new URL(url);
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(feedUrl));
        feed.setUri(url);
        return feed;
    }

    public static <T> T getConvertedFeed(String url, FeedConverter<T> converter) throws IOException, FeedException {
        SyndFeed feed = FeedFetcher.getFeed(url);
        feed.setUri(url);
        return converter.convert(feed);
    }
}
