package com.hanquez.feedfetcher.api.fetcher;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import io.github.jsonSnapshot.SnapshotMatcher;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FeedFetcherTest {

    private static final String NIPTECH = "http://feeds.feedburner.com/niptechpodcast";
//    private static final SyndFeedConverter syndFeedConverter = new SyndFeedConverter();
    private static SyndFeed feed;
//    private static SyndFeed convertedFeed;

    @BeforeClass
    public static void beforeAll() throws IOException, FeedException {
        //Start json-snapshot
        SnapshotMatcher.start();

        //Get the feed by FeedFetcher API
        feed = FeedFetcher.getFeed(NIPTECH);
//        convertedFeed = FeedFetcher.getConvertedFeed(NIPTECH, syndFeedConverter);
    }

    @AfterClass
    public static void afterAll() {
        SnapshotMatcher.validateSnapshots();
    }

    @Test
    public void getFeedFromRomeTools() throws IOException, FeedException {
        URL feedUrl = new URL(NIPTECH);
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(feedUrl));
        List<SyndEntry> entries = feed.getEntries();
        assertThat(entries).isNotNull();
    }

    @Test
    public void getFeedEntries() {
        List<SyndEntry> entries = feed.getEntries();
        assertThat(entries).isNotEmpty();
    }

    @Test
    public void getDescriptionByFeedFetcherAPI() {
        String description = feed.getDescription();
        assertThat(description).isNotNull();
        assertThat(description).isNotEmpty();
        SnapshotMatcher.expect(description).toMatchSnapshot();
    }

}
