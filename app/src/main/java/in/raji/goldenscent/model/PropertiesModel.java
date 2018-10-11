package in.raji.goldenscent.model;

/**
 * Created by Raji on 11/10/2018.
 */
public class PropertiesModel {

    private int imageResource;
    private String title;
    private String description;
    private String original_price;
    private String offer_price;
    private boolean onOffer;

    public PropertiesModel(int imageResource, String title, String description, String original_price, String offer_price, boolean onOffer) {
        this.imageResource = imageResource;
        this.title = title;
        this.description = description;
        this.original_price = original_price;
        this.offer_price = offer_price;
        this.onOffer = onOffer;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(String original_price) {
        this.original_price = original_price;
    }

    public String getOffer_price() {
        return offer_price;
    }

    public void setOffer_price(String offer_price) {
        this.offer_price = offer_price;
    }

    public boolean isOnOffer() {
        return onOffer;
    }

    public void setOnOffer(boolean onOffer) {
        this.onOffer = onOffer;
    }
}
