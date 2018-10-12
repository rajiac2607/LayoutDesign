package in.raji.goldenscent.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;

import java.util.ArrayList;

import in.raji.goldenscent.R;
import in.raji.goldenscent.model.PropertiesModel;

/**
 * Created by Raji on 11/10/2018.
 */
public class BestSellerViewModel extends AndroidViewModel {
    private ArrayList<PropertiesModel> propertiesModels = new ArrayList<>();

    public BestSellerViewModel(@NonNull Application application) {
        super(application);
        init();
    }

    private void init() {
        String[] titles = getApplication().getResources().getStringArray(R.array.best_seller_titles);
        String[] desc = getApplication().getResources().getStringArray(R.array.best_seller_desc_array);
        String[] original_price = getApplication().getResources().getStringArray(R.array.original_price_array);
        String[] offer_price = getApplication().getResources().getStringArray(R.array.offer_price_array);

        final TypedArray images = getApplication().getResources().obtainTypedArray(R.array.best_seller_image);

        for (int i = 0; i < titles.length; i++)
            propertiesModels.add(new PropertiesModel(titles[i],
                    desc[i], original_price[i], offer_price[i], images.getResourceId(i, -1), false));

        propertiesModels.get(0).setOnOffer(true);
        propertiesModels.get(3).setOnOffer(true);


    }

    public ArrayList<PropertiesModel> getPropertiesModels() {
        return propertiesModels;
    }

    public void setPropertiesModels(ArrayList<PropertiesModel> propertiesModels) {
        this.propertiesModels = propertiesModels;
    }
}
