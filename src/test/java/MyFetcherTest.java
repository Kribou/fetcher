import com.hanquez.feedfetcher.FeedFetcher;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertTrue;

public class MyFetcherTest {

    private static final String NIPTECH =  "http://feeds.feedburner.com/niptechpodcast";

    @Test
    public void getFeedFromRomeTools() {
        try {
            URL feedUrl = new URL(NIPTECH);
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedUrl));
            assertTrue("No entries set",feed.getEntries().size() > 0);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    @Test
    public void getFeedByFetcherAPI() throws IOException, FeedException {
        SyndFeed feed = FeedFetcher.getFeed(NIPTECH);
        assertTrue("No entries set", feed.getEntries().size() > 0);
    }
}
