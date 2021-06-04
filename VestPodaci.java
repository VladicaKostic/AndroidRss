package rs.sindikatlfs.sindikatlekaraifarmaceutasrbije;

/**
 * Created by Vladica on 1/28/2016.
 */
public class VestPodaci {
    public String title;
    public String link;
    public String imageUrl = null;
    public String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
}
