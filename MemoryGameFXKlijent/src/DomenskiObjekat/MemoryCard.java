package DomenskiObjekat;

import java.util.Objects;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author mario
 */
public class MemoryCard extends ImageView {

    private static final String backCard = "/pics/backCard.png";
    private String url;
    private boolean flipped;

    public MemoryCard() {
        this.setFitWidth(140);
        this.setFitHeight(120);
        this.setPreserveRatio(true);
    }

    public MemoryCard(String url) {
        super(backCard);
        this.url = url;
        this.setFitWidth(140);
        this.setFitHeight(120);
        this.setPreserveRatio(true);
    }

    public static String getBackCard() {
        return backCard;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isFlipped() {
        return flipped;
    }

    public void setFlipped(boolean flipped) {
        this.flipped = flipped;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.url);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        MemoryCard kartica = (MemoryCard) obj;
        if (!((MemoryCard) obj).getId().equals(this.getId())) {
            return false;
        }
        return Objects.equals(this.url, kartica.url);
    }

    public void close() {
        this.setImage(new Image(backCard));
    }

    public void showCard() {
        this.setImage(new Image(url));
    }

    public void open() {
        this.setImage(new Image(url));
        this.flipped = true;
        this.setFitWidth(140);
        this.setFitHeight(120.0);
        this.setPreserveRatio(true);
    }

    public boolean equalsUrl(Object obj) {
        return obj instanceof MemoryCard
                && ((MemoryCard) obj).url.equals(url);
    }

}
