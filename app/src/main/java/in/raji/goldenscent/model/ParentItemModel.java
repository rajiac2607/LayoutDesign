package in.raji.goldenscent.model;

import java.util.ArrayList;

/**
 * Created by Raji on 11/10/2018.
 */
public class ParentItemModel {
    private String title;
    private ArrayList<ChildItemModel> children;

    public ParentItemModel(String title, ArrayList<ChildItemModel> children) {
        this.title = title;
        this.children = children;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<ChildItemModel> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<ChildItemModel> children) {
        this.children = children;
    }
}
