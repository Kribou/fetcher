package com.hanquez.feedfetcher.api.fetcher;

import com.hanquez.feedfetcher.impl.converter.SyndFeedConverter;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static io.github.jsonSnapshot.SnapshotMatcher.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class FeedFetcherTest {

    private static final String NIPTECH = "http://feeds.feedburner.com/niptechpodcast";
    private static final SyndFeedConverter syndFeedConverter = new SyndFeedConverter();
    private static SyndFeed feed;
    private static SyndFeed convertedFeed;

    @BeforeClass
    public static void beforeAll() throws IOException, FeedException {
        //Start json-snapshot
        start();

        //Get the feed by FeedFetcher API
        feed = FeedFetcher.getFeed(NIPTECH);
        convertedFeed = FeedFetcher.getConvertedFeed(NIPTECH, syndFeedConverter);
    }

    @AfterClass
    public static void afterAll() {
        validateSnapshots();
    }

    @Test
    public void getFeedFromRomeTools() {
        try {
            URL feedUrl = new URL(NIPTECH);
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedUrl));
            List<SyndEntry> entries = feed.getEntries();
            assertNotNull(entries);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    @Test
    public void getFeedEntries() {
        List<SyndEntry> entries = feed.getEntries();
        assertNotNull(entries);
        assertTrue("No entries found", entries.size() > 0);
    }

    @Test
    public void getDescriptionByFeedFetcherAPI() {
        String description = feed.getDescription();
        assertNotNull("No description found", description);
        assertTrue("Empty description", !description.isEmpty());
        expect(description).toMatchSnapshot();
    }

    @Test
    public void getConvertedFeed() {
        List<SyndEntry> entries = convertedFeed.getEntries().subList(0, 1);
        System.out.println("entries = " + entries);
        System.out.println(entries.size());
    }
}
