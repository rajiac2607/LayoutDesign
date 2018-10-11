package in.raji.goldenscent.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;

import java.util.ArrayList;

import in.raji.goldenscent.R;
import in.raji.goldenscent.model.MasterItemModel;

/**
 * Created by Raji on 10/10/2018.
 */
public class MasterViewModel extends AndroidViewModel {

    ArrayList<MasterItemModel> modelArrayList = new ArrayList<>();

    public MasterViewModel(@NonNull Application application) {
        super(application);
        init();

    }

    private void init() {

        String[] titles = getApplication().getResources().getStringArray(R.array.master_titles);
      //  int[] images = getApplication().getResources().getIntArray(R.array.images);
//        int[] images = {R.drawable.ic_makeup, R.drawable.ic_skin_care, R.drawable.ic_hair_care,
//                R.drawable.ic_tools, R.drawable.ic_home_fragrances, R.drawable.ic_gift,
//                R.drawable.ic_men};

        final TypedArray images = getApplication().getResources().obtainTypedArray(R.array.images);
        for (int i = 0; i < titles.length; i++)
            modelArrayList.add(new MasterItemModel(titles[i], images.getResourceId(i,-1)));

    }

    public ArrayList<MasterItemModel> getModelArrayList() {
        return modelArrayList;
    }

    public void setModelArrayList(ArrayList<MasterItemModel> modelArrayList) {
        this.modelArrayList = modelArrayList;
    }
}
