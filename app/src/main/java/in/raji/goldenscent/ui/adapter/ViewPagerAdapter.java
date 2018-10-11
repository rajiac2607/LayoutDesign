package in.raji.goldenscent.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import in.raji.goldenscent.R;
import in.raji.goldenscent.databinding.FragmentMasterBinding;
import in.raji.goldenscent.databinding.ItemPropertiesBinding;
import in.raji.goldenscent.model.PropertiesModel;

/**
 * Created by Raji on 11/10/2018.
 */
public class ViewPagerAdapter extends PagerAdapter {
    ArrayList<PropertiesModel> models;

    public ViewPagerAdapter(ArrayList<PropertiesModel> models) {
        this.models = models;
    }

    @Override
    public int getCount() {
        return models.size() / 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        FragmentMasterBinding binding = DataBindingUtil.inflate(LayoutInflater.from(container.getContext()), R.layout.fragment_master, container, false);
        binding.recyclerView.setAdapter(new RecyclerViewAdapter((ArrayList<PropertiesModel>) models.subList(position * 3, position * 3 + 2)));
        return binding.getRoot();
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.PropertiesViewHolder> {

        ArrayList<PropertiesModel> models;

        public RecyclerViewAdapter(ArrayList<PropertiesModel> models) {
            this.models = models;
        }

        class PropertiesViewHolder extends RecyclerView.ViewHolder {
            ItemPropertiesBinding binding;

            public PropertiesViewHolder(@NonNull ItemPropertiesBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }

            void bind(PropertiesModel itemModel) {
                binding.setModel(itemModel);

            }
        }

        @NonNull
        @Override
        public PropertiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            ItemPropertiesBinding binding =
                    DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_properties, parent, false);
            return new PropertiesViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull PropertiesViewHolder holder, int position) {
            holder.bind(models.get(position));

        }



        @Override
        public int getItemCount() {
            return models.size();
        }
    }
}
