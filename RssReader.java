package rs.sindikatlfs.sindikatlekaraifarmaceutasrbije;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Vladica on 1/28/2016.
 */
public class RssReader {

    private String rssUrl;

    public RssReader(String rssUrl) {
        this.rssUrl = rssUrl;
    }

    public List<VestPodaci> getItems() throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        RssParseHandler handler = new RssParseHandler();
        saxParser.parse(rssUrl, handler);

        return handler.getItems();
    }
}
