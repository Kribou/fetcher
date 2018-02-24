import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class MyFetcher {
    public static void main(String[] args) {
        try {
            URL feedUrl = new URL("http://feeds.feedburner.com/niptechpodcast");
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedUrl));
            List<SyndEntry> entries = feed.getEntries().stream().limit(1).collect(Collectors.toList());
            feed.setEntries(entries);
            System.out.println(feed);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
}
