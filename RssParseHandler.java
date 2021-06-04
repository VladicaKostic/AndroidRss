package rs.sindikatlfs.sindikatlekaraifarmaceutasrbije;

import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.xml.sax.Attributes;

/**
 * Created by Vladica on 1/28/2016.
 */
public class RssParseHandler extends DefaultHandler {

    private List<VestPodaci> podaci;
    private VestPodaci trenutniPodatak;
    private boolean parsingTitle;
    private boolean parsingLink;
    private boolean parsingDate;
    private boolean parsingImage;

    public RssParseHandler() {
        podaci = new ArrayList();
    }

    public List<VestPodaci> getItems() {
        return podaci;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("item".equals(qName)) {
            trenutniPodatak = new VestPodaci();
        } else if ("title".equals(qName)) {
            parsingTitle = true;
        } else if ("link".equals(qName)) {
            parsingLink = true;
        } else if ("pubDate".equals(qName)) {
            parsingDate = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("item".equals(qName)) {
            podaci.add(trenutniPodatak);
            trenutniPodatak = null;
        } else if ("title".equals(qName)) {
            parsingTitle = false;
        } else if ("link".equals(qName)) {
            parsingLink = false;
        } else if ("pubDate".equals(qName)) {
            parsingDate = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (parsingTitle) {
            if (trenutniPodatak != null)
                trenutniPodatak.setTitle(new String(ch, start, length));
        } else if (parsingLink) {
            if (trenutniPodatak != null) {
                trenutniPodatak.setLink(new String(ch, start, length));
                parsingLink = false;
            }
        } else if (parsingDate) {
            if (trenutniPodatak != null) {
                trenutniPodatak.setDate(new String(ch, start, length));
                parsingDate = false;
            }
        }
    }
}
