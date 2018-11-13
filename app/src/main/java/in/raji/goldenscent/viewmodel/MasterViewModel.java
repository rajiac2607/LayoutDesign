package in.raji.goldenscent.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;

import java.util.ArrayList;

import in.raji.goldenscent.R;
import in.raji.goldenscent.model.ChildItemModel;

/**
 * Created by Raji on 10/10/2018.
 */
public class MasterViewModel extends AndroidViewModel {

    private ArrayList<ChildItemModel> modelArrayList = new ArrayList<>();

    public MasterViewModel(@NonNull Application application) {
        super(application);
        init();

    }

    private void init() {

        String[] titles = getApplication().getResources().getStringArray(R.array.master_titles);
        final TypedArray images = getApplication().getResources().obtainTypedArray(R.array.master_images);
        for (int i = 0; i < titles.length; i++)
            modelArrayList.add(new ChildItemModel(titles[i], images.getResourceId(i, -1)));

    }

    public ArrayList<ChildItemModel> getModelArrayList() {
        return modelArrayList;
    }

    public void setModelArrayList(ArrayList<ChildItemModel> modelArrayList) {
        this.modelArrayList = modelArrayList;
    }
}
