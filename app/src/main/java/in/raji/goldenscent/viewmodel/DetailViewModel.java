package in.raji.goldenscent.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;

import java.util.ArrayList;

import in.raji.goldenscent.R;
import in.raji.goldenscent.model.ChildItemModel;
import in.raji.goldenscent.model.ParentItemModel;

/**
 * Created by Raji on 10/10/2018.
 */
public class DetailViewModel extends AndroidViewModel {

    ArrayList<ParentItemModel> items = new ArrayList<>();

    public DetailViewModel(@NonNull Application application) {
        super(application);
        init();
    }


    private void init() {
        String[] title = getApplication().getResources().getStringArray(R.array.expandable_list_titles);

        ArrayList<ChildItemModel> children = new ArrayList<>();
        String[] titles = getApplication().getResources().getStringArray(R.array.expandable_list_child_titles);
        final TypedArray images = getApplication().getResources().obtainTypedArray(R.array.expandable_list_images);
        for (int i = 0; i < titles.length; i++)
            children.add(new ChildItemModel(titles[i], images.getResourceId(i, -1)));


        for (int i = 0; i < title.length; i++)
            items.add(new ParentItemModel(title[i], children));


    }

    public ArrayList<ParentItemModel> getItems() {
        return items;
    }

    public void setItems(ArrayList<ParentItemModel> items) {
        this.items = items;
    }
}
