package in.raji.goldenscent.model;

/**
 * Created by Raji on 10/10/2018.
 */
public class MasterItemModel {
    private String title;
    private int imgResource;

    public MasterItemModel(String title, int imgResource) {
        this.title = title;
        this.imgResource = imgResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }
}
