package com.hanquez.feedfetcher;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;

public class FeedFetcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeedFetcher.class.getName());

    public static SyndFeed getFeed(String url) throws IOException, FeedException {
        URL feedUrl = new URL(url);
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(feedUrl));
        LOGGER.debug(String.format("%S entries found", feed.getEntries().size()));
        return feed;
    }

}
